package com.publicwelfare.controllers.backstage;

import com.publicwelfare.entity.tables.LoginInfo;
import com.publicwelfare.services.LoginBackstageService;
import org.springframework.web.bind.annotation.*;
import com.publicwelfare.entity.common.CommonResult;

import javax.annotation.Resource;

/**
 * @author public-welfare
 * @date 2020/9/27
 * 后台登录controller
 */
@RestController
@RequestMapping("/backstage")
public class LoginBackstageController {

    @Resource
    LoginBackstageService loginBackstageService;

    /**
     * 后台登录接口
     @ param loginInfo
     * @return commonResult 状态码，状态信息，数据
     */
    @PostMapping("/login")
    public CommonResult checkLogin(@RequestBody LoginInfo loginInfo) {
        return loginBackstageService.checkLogin(loginInfo.getUserId(),loginInfo.getPassword());
    }
}
