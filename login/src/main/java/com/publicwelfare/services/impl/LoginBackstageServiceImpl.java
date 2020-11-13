package com.publicwelfare.services.impl;

import com.publicwelfare.mapper.LoginMapper;
import com.publicwelfare.services.LoginBackstageService;
import org.springframework.stereotype.Service;
import com.publicwelfare.entity.common.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author public-welfare
 * @date 2020/9/27
 * 后台登录服务实现类
 */
@Service
public class LoginBackstageServiceImpl implements LoginBackstageService {

    @Resource
    LoginMapper loginMapper;

    @Override
    public CommonResult checkLogin(String userId, String password) {
        Integer count = loginMapper.ifInLoginInfo(userId);
        if(count == 0) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有此用户");
        }
        Map<String,Object> loginInfo = loginMapper.loginTypeAndInfo(userId);
        System.out.println(loginInfo);
        try {
            if (!loginInfo.get("password").equals(password)) {
                return new CommonResult(StatusCodeAndMsg.PASSWORD_ERROR, "密码错误");
            } else {
                return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE, "登陆成功", loginInfo);
            }
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR, "数据库错误");
        }
    }
}
