package com.publicwelfare.controller;

import com.publicwelfare.services.HomeService;
import org.apache.ibatis.annotations.Case;
import org.springframework.web.bind.annotation.*;
import parentpackage.entities.common.CommonResult;
import parentpackage.entities.common.StatusCodeAndMsg;

import javax.annotation.Resource;

/**
 * 主界面controller
 * @author zepeng.lin
 * @date 2020/10/20
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Resource
    HomeService service;

    /**
     * 用于查询主界面的基本信息
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/info/{userId}")
    public CommonResult homeInfo(@PathVariable(value = "userId") String userId) {
        String userType = service.getUserType(userId);
        System.out.println(userType);
        switch (userType) {
            case "志愿者": return service.getVolunteerInfo(userId);
            case "NGO": return service.getNgoInfo(userId);
            case "街道": return service.getStreetInfo(userId);
            default: return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
    }
}
