package com.publicwelfare.services.impl;

import com.publicwelfare.mapper.HomeMapper;
import com.publicwelfare.mapper.MyWelfareMapper;
import com.publicwelfare.services.MyWelfareService;
import org.springframework.stereotype.Service;
import parentpackage.entities.common.CommonResult;
import parentpackage.entities.common.StatusCodeAndMsg;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zepeng.lin
 * @date 2020/10/20
 */
@Service
public class MyWelfareServiceImpl implements MyWelfareService {

    @Resource
    MyWelfareMapper welfareMapper;

    @Resource
    HomeMapper homeMapper;

    @Override
    public CommonResult myWelfareList(String userId) {
        Map<String, String> user = homeMapper.selectUserTypeById(userId);
        String userType;
        try {
            userType = user.get("userType");
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        List<Map<String,String>> welfareList = new ArrayList<>();
        switch (userType) {
            case "志愿者": welfareList = welfareMapper.volunteerList(userId); break;
            case "NGO": welfareList = welfareMapper.ngoList(userId); break;
            case "街道": welfareList = welfareMapper.streetList(userId); break;
            default:
        }
        if(welfareList.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",welfareList);
    }

    @Override
    public CommonResult volunteerList1(String userId) {
        List<Map<String,String>> list = welfareMapper.volunteerList1(userId);
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult volunteerList2(String userId) {
        List<Map<String,String>> list = welfareMapper.volunteerList2(userId);
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult ngoListBefore(String userId) {
        List<Map<String,String>> list = welfareMapper.ngoListBefore(userId);
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult ngoListAfter(String userId) {
        List<Map<String,String>> list = welfareMapper.ngoListAfter(userId);
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult ngoListFailed(String userId) {
        List<Map<String,String>> list = welfareMapper.ngoListFailed(userId);
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }
}
