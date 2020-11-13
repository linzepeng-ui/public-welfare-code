package com.publicwelfare.services.impl;

import com.github.tobato.fastdfs.exception.FdfsIOException;
import com.publicwelfare.entity.CreateUserId;
import com.publicwelfare.entity.FastDFSClient;
import com.publicwelfare.entity.GetOpenId;
import com.publicwelfare.entity.WxResult;
import com.publicwelfare.entity.common.CommonResult;
import com.publicwelfare.entity.common.StatusCodeAndMsg;
import com.publicwelfare.mapper.WxStartMapper;
import com.publicwelfare.services.WxStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.publicwelfare.entity.tables.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author public-welfare
 * @date 2020/9/27
 */
@Service
public class WxStartServiceImpl implements WxStartService {

    @Resource
    private WxStartMapper mapper;

    @Resource
    private ThreadPoolTaskExecutor executor;

    @Resource
    private RestTemplate restTemplate;

    private CreateUserId createUserId;

    @Autowired
    private FastDFSClient fastDfsClient;

    /**
     * 身份证号长度
     */
    private Integer identifiedLength = 18;

    /**
     * 电话号码长度
     */
    private Integer telephoneLength1 = 11;
    private Integer telephoneLength2 = 8;

    /**
     * 邮箱验证的正则表达式
     */
    private String ruleEmail = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    /**
     * 用于存储用户类别对应数据库表名的关系
     * @return map(类别,表名)
     */
    private Map<String,String> getTypeToTable() {
        Map<String,String> typeToTable = new HashMap<>();
        typeToTable.put("志愿者","volunteer_info");
        typeToTable.put("NGO","NGO_info");
        return typeToTable;
    }

    /**
     * 检查邮箱格式
     * @param email 邮箱地址
     * @return true为验证通过，false为未通过
     */
    private boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(ruleEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 微信端登录服务
     * @param code 微信用户登录code
     * @return CommonResult通用类
     */
    @Override
    public CommonResult wxCheckLogin(String code) {
        System.out.println("code = "+code);
        WxResult result = new GetOpenId(restTemplate).getOpenid(code);
        System.out.println("openId = "+result.getOpenid());
        String openId = result.getOpenid();
        Map<String, String> putOpenId = new HashMap<>();
        putOpenId.put("openId",openId);
        try {
            if(!"0".equals(result.getErrcode())) {
                return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR,result.getErrmsg());
            }
            Map<String, Object> countMap = mapper.selectCountByOpenId(openId);
            try {
                /* 获取查到的count数据库条目值，为0则没有此用户，为1则有*/
                Long count = (Long) countMap.get("count");
                if (count == 0) {
                    return new CommonResult<>(StatusCodeAndMsg.RESULT_NOT_FOUND, "没有此人信息",putOpenId);
                } else if (count == 1) {
                    UserInfo info = mapper.selectUserByOpenId(openId);
                    System.out.println(info);
                    switch ((String) countMap.get("user_type")) {
                        case "志愿者":
                            VolunteerInfo volunteerInfo = mapper.selectVolunteerExpandInfo(info.getUserId());
                            info.setExpandInfo(volunteerInfo);
                            break;
                        case "NGO":
                            NgoInfo ngoInfo = mapper.selectNgoExpandInfo(info.getUserId());
                            info.setExpandInfo(ngoInfo);
                            break;
                        default:
                    }
                    return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE, "查询成功", info);
                }
            } catch (NullPointerException e) {
                return new CommonResult<>(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有此用户",putOpenId);
            } catch (Exception e) {
                return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR, "数据库错误");
            }
        } catch (NullPointerException e) {
            return new CommonResult<>(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有此用户",putOpenId);
        }
        return null;
    }

    /**
     * 此接口用于用户进行注册基本信息使用
     * @param username 用户名
     * @param userType 用户类型
     * @param identifiedCardId 用户身份证号
     * @param telNum 用户电话号码
     * @param file 用户头像
     * @param emailAddr 邮箱地址
     * @return CommonResult 状态码 状态描述 @nullable数据
     */
    @Override
    public synchronized CommonResult normalRegister(String username , String openId, String userType, String identifiedCardId, String telNum, String filePath, String emailAddr) throws ExecutionException, InterruptedException {
        UserInfo userInfo = new UserInfo();
        //通过code获取用户微信openID
//        WxResult wxResult = new GetOpenId(restTemplate).getOpenid(code);
//        if(!"0".equals(wxResult.getErrcode())) {
//            switch (wxResult.getErrcode()) {
//                case "404": return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR,"code未输入或服务器错误");
//                case "-1":
//                case "40029":
//                case "40051": return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR,wxResult.getErrmsg());
//                default: return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR,"未知错误");
//            }
//        }
        //先按照用户的类别来进行数据库插入操作，比如用户注册类别是ngo则填ngo,同时生成审核表
        userInfo.setOpenId(openId);
        try {
            userInfo.setUsername(username);
            userInfo.setUserType(userType);
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "未填写用户名");
        }
        try {
            if (identifiedCardId.length() != identifiedLength) {
                return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "身份证号错误");
            }
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "身份证号未填写");
        }
        try {
            userInfo.setIdentifiedCardId(identifiedCardId);
            System.out.println(telNum.length());
            if (telNum.length() != telephoneLength1) {
                return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "电话号码错误");
            }
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "电话号码未填写");
        }
        userInfo.setTelephoneNum(telNum);
//        try {
//            if(file == null) {
//                userInfo.setImageUrl(" ");
//            } else {
//                String imageUrl = fastDfsClient.uploadFile(file);
//                userInfo.setImageUrl(imageUrl);
//            }
//        } catch (NullPointerException e) {
//            userInfo.setImageUrl(" ");
//        } catch (FdfsIOException e) {
//            return new CommonResult(StatusCodeAndMsg.SERVICE_ERROR,"服务器连接超时");
//        } catch (Exception e) {
//            return new CommonResult(StatusCodeAndMsg.SERVICE_ERROR,"服务器出错");
//        }
        userInfo.setImageUrl(filePath);
        try {
            if (!this.checkEmail(emailAddr)) {
                return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "邮箱格式错误");
            }
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "邮箱未填写");
        }
        userInfo.setEmailAddr(emailAddr);
        createUserId = new CreateUserId(mapper);
        //新建一个callable线程
        Callable getUserId = createUserId;
        //执行任务并获取callable对象
        Future future = executor.submit(getUserId);
        userInfo.setUserId(future.get().toString());
        //获取数据库操作的行数，1为插入成功，0为失败
        int insertResult = mapper.registerBasicUserInfo(userInfo);
        if(insertResult == 1) {
            int expandResult = 0;
            //在三个角色分别的拓展信息表中自动生成一行信息
            switch (userType) {
                case "志愿者": expandResult = mapper.volunteerAutoRegister(userInfo.getUserId()); break;
                case "NGO": expandResult = mapper.ngoAutoRegister(userInfo.getUserId()); break;
                case "街道": expandResult = mapper.streetAutoRegister(userInfo.getUserId()); break;
                default:
            }
            if(expandResult == 1) {
                Map<String, String> map = new HashMap<>();
                map.put("userId", future.get().toString());
                map.put("imageUrl",userInfo.getImageUrl());
                return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE, "注册成功", map);
            }
            return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR,"数据库错误");
        } else {
            return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR,"数据库错误");
        }
    }

    /**
     * 此接口用于ngo拓展信息注册
     * @param userId 用户id
     * @param introduce ngo简介
     * @param location ngo位置
     * @param picture ngo图片
     * @return CommonResult 状态码 状态描述 @nullable数据
     */
    @Override
    public CommonResult ngoRegister(String userId, String introduce, String location, MultipartFile picture) throws IOException {
        String pictureUrl;
        try {
            pictureUrl = fastDfsClient.uploadFile(picture);
        } catch (FdfsIOException e) {
            return new CommonResult(StatusCodeAndMsg.SERVICE_ERROR,"服务器连接超时");
        }
        int result = mapper.ngoRegister(userId,introduce,location,pictureUrl);
        if(result == 1) {
            return new CommonResult(StatusCodeAndMsg.SUCCESS_CODE,"注册成功");
        }
        return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR,"注册失败");
    }

    /**
     * 此接口用于街道拓展信息注册
     * @param userId 用户id
     * @param introduce 街道简介
     * @param location 街道位置
     * @param picture 街道图片
     * @return CommonResult 状态码 状态描述 @nullable数据
     */
    @Override
    public CommonResult streetRegister(String userId, String introduce, String location, MultipartFile picture) throws IOException {
        String pictureUrl;
        try {
            pictureUrl = fastDfsClient.uploadFile(picture);
        }  catch (FdfsIOException e) {
            return new CommonResult(StatusCodeAndMsg.SERVICE_ERROR,"服务器连接超时");
        }
        System.out.println(pictureUrl);
        int result = mapper.streetRegister(userId,introduce,location,pictureUrl);
        if(result == 1) {
            return new CommonResult(StatusCodeAndMsg.SUCCESS_CODE,"注册成功");
        }
        return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR,"注册失败");
    }
}
