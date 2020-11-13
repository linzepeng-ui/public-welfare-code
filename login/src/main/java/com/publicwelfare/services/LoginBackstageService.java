package com.publicwelfare.services;

import com.publicwelfare.entity.common.CommonResult;
import com.publicwelfare.entity.common.StatusCodeAndMsg;

/**
 * @author public-welfare
 * @date 2020/9/27
 */
public interface LoginBackstageService {

    /**
     * 检查后台登录接口
     * @param userId 用户id
     * @param password 用户密码
     * @return CommonResult<T>
     */
    public CommonResult checkLogin(String userId, String password);
}
