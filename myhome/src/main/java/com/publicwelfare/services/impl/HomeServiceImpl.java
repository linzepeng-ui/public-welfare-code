package com.publicwelfare.services.impl;

import com.publicwelfare.mapper.HomeMapper;
import com.publicwelfare.services.HomeService;
import org.springframework.stereotype.Service;
import parentpackage.entities.common.CommonResult;
import parentpackage.entities.common.StatusCodeAndMsg;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zepeng.lin
 * @date 2020/10/20
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    HomeMapper mapper;

    @Override
    public String getUserType(String userId) {
        String userType;
        try {
            userType = mapper.selectUserTypeById(userId).get("userType");
        } catch (NullPointerException e) {
            userType = "游客";
        }
        return userType;
    }

    @Override
    public CommonResult getVolunteerInfo(String userId) {
        Map<String,String> result1 = mapper.selectVolunteerHelpPersonNum(userId);
        Map<String,String> result2 = mapper.selectVolunteerDoneService(userId);
        result1.put("haveDoneWelfare",result2.get("haveDoneWelfare"));
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",result1);
    }

    @Override
    public CommonResult getNgoInfo(String userId) {
        Map<String,String> result1 = mapper.selectNgoEveryWelfare(userId);
        Map<String,String> result2 = mapper.selectNgoHaveDoneWelfare(userId);
        result1.put("haveDoneWelfare",result2.get("haveDoneWelfare"));
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",result1);
    }

    @Override
    public CommonResult getStreetInfo(String userId) {
        Map<String,String> result1 = mapper.selectStreetEveryWelfare(userId);
        Map<String,String> result2 = mapper.selectStreetHaveDoneWelfare(userId);
        result1.put("haveDoneWelfare",result2.get("haveDoneWelfare"));
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",result1);
    }
}
