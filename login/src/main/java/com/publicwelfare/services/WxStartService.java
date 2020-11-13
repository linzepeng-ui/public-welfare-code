package com.publicwelfare.services;

import com.publicwelfare.entity.common.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author public-welfare
 * @date 2020/9/27
 */
public interface WxStartService {

    /**
     * 此接口用于验证用户是否在平台注册，注册过就直接登录，否则进入注册
     * @param code 微信用户登录code
     * @return CommonResult 状态码 状态描述 @nullable数据
     */
    public CommonResult wxCheckLogin(String code);

    /**
     * 此接口用于用户进行注册基本信息使用
     * @param username 用户名
     * @param openId 微信用户登录code
     * @param userType 用户类型
     * @param identifiedCardId 用户身份证号
     * @param telNum 用户电话号码
     * @param file 用户头像
     * @param emailAddr 邮箱地址
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws IOException
     * @return CommonResult 状态码 状态描述 @nullable数据
     */
    public CommonResult normalRegister(String username , String openId, String userType, String identifiedCardId,
                                                                       String telNum, String filePath, String emailAddr) throws ExecutionException, InterruptedException, IOException;

    /**
     * 此接口用于ngo拓展信息注册
     * @param userId 用户id
     * @param introduce ngo简介
     * @param location ngo位置
     * @param picture ngo图片
     * @throws IOException
     * @return CommonResult 状态码 状态描述 @nullable数据
     */
    public CommonResult ngoRegister(String userId, String introduce, String location, MultipartFile picture) throws IOException;

    /**
     * 此接口用于街道拓展信息注册
     * @param userId 用户id
     * @param introduce 街道简介
     * @param location 街道位置
     * @param picture 街道图片
     * @throws IOException
     * @return CommonResult 状态码 状态描述 @nullable数据
     */
    public CommonResult streetRegister(String userId, String introduce, String location, MultipartFile picture) throws IOException;
}
