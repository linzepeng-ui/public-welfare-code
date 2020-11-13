package com.publicwelfare.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.publicwelfare.entity.tables.LoginInfo;

import java.util.Map;

/**
 * @author public-welfare
 * @date 2020/9/27
 * springboot-mybatis 用户登录查询更正
 */
@Mapper
public interface LoginMapper {

    /**
     * 通过userId查询是否存在此用户的登录信息
     * @param userId 用户id
     * @return 查询到的条目，0为没有此用户信息，1为有此用户信息
     */
    @Select("select count(*) from login_info where user_id = #{userId}")
    public Integer ifInLoginInfo(String userId);

//    /**
//     * 后台通过userId查询用户信息,仅限于平台和街道
//     * @param userId 用户id
//     * @return loginInfo登录映射表
//     */
//    @Select("select * from login_info where user_id = #{userId}")
//    public LoginInfo loginInfoBackstage(String userId);

    /**
     * 后台通过userId查询用户信息,仅限于平台和街道
     * @param userId 用户id
     * @return 返回用户login信息，用户名和用户登录类别
     */
    @Select("select user_info.user_id,tel_num,password,user_name,user_type\n" +
            "from user_info,login_info\n" +
            "where user_info.user_id = #{userId} and user_info.user_id = login_info.user_id")
    public Map<String,Object> loginTypeAndInfo(String userId);
}
