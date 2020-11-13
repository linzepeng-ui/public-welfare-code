package com.publicwelfare.controller;

import com.publicwelfare.services.MyWelfareService;
import org.springframework.web.bind.annotation.*;
import parentpackage.entities.common.CommonResult;

import javax.annotation.Resource;

/**
 * 我的公益接口
 * @author zepeng.lin
 * @date 2020/10/20
 */
@RestController
@RequestMapping("/myWelfare")
public class MyWelfareController {

    @Resource
    MyWelfareService service;

    /**
     * 获取我的公益清单列表
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/list/{userId}")
    public CommonResult myWelfare(@PathVariable(value = "userId") String userId) {
        return service.myWelfareList(userId);
    }

    /**
     * 获取志愿者进行中公益信息
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/volunteer_list1/{userId}")
    public CommonResult volunteerList1(@PathVariable(value = "userId") String userId) {
        return service.volunteerList1(userId);
    }

    /**
     * 获取志愿者已完成公益信息
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/volunteer_list2/{userId}")
    public CommonResult volunteerList2(@PathVariable(value = "userId") String userId) {
        return service.volunteerList2(userId);
    }

    @GetMapping("/ngo_list_before/{userId}")
    public CommonResult ngoListBefore(@PathVariable(value = "userId") String userId) {
        return service.ngoListBefore(userId);
    }

    @GetMapping("/ngo_list_after/{userId}")
    public CommonResult ngoListAfter(@PathVariable(value = "userId") String userId) {
        return service.ngoListAfter(userId);
    }

    @GetMapping("/ngo_list_failed/{userId}")
    public CommonResult ngoListFailed(@PathVariable(value = "userId") String userId) {
        return service.ngoListFailed(userId);
    }
}
