package com.publicwelfare.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import com.publicwelfare.entity.tables.*;

import java.util.Map;

/**
 * @author public-welfare
 * @date 2020/9/27
 * 微信小程序端的登录和注册mapper
 */
@Mapper
public interface WxStartMapper {

    /**
     * 从user_id用户基本信息表中查看是否存在openId为传入参数的用户,并同时查询用户类别
     * @param openId 微信用户唯一标识符
     * @return 查到的行数，1为有此用户，0为没有此用户
     */
    @Select("select count(*) as count,user_type " +
            "from user_info " +
            "where open_id = #{openId} " +
            "group by user_id")
    public Map<String,Object> selectCountByOpenId(String openId);

    /**
     * 根据之前sql语句查到的用户类别进行用户基本信息的查询
     * @param openId 微信用户唯一标识符
     * @return 返回一个UserInfo对象。该对象可能为泛型，可能不为泛型，根据用户是否有扩展信息而决定
     */
    @Select("select * from user_info " +
            "where open_id = #{openId}")
    public UserInfo selectUserByOpenId( String openId);

    /**
     * 通过用户userId查询志愿者用户的扩展信息
     * @param userId 用户ID
     * @return 志愿者用户扩展信息
     */
    @Select("select * from volunteer_info where user_id = #{userId}")
    public VolunteerInfo selectVolunteerExpandInfo(@Param("userId") String userId);

    /**
     * 通过用户userId查询NGO用户的扩展信息
     * @param userId 用户ID
     * @return NGO用户扩展信息
     */
    @Select("select * from NGO_info where user_id = #{userId}")
    public NgoInfo selectNgoExpandInfo(@Param("userId") String userId);

    /**
     * 注册用户的基本信息
     * @param info 用户基本信息类
     * @return 修改的行数
     */
    @Insert("insert into user_info values" +
            "(#{info.userId},#{info.openId},#{info.username},#{info.userType}" +
            ",#{info.identifiedCardId},#{info.telephoneNum},#{info.imageUrl},#{info.emailAddr})")
    public Integer registerBasicUserInfo(@Param("info") UserInfo info);

    /**
     * 查询有多少已注册用户
     * @return 数量
     */
    @Select("select count(user_id_count) from user_count")
    public Integer getUserRegisterCount();

    /**
     * 第一个注册用户
     */
    @Insert("insert into user_count values(1,now())")
    public void firstInsertRegisterCount();

    /**
     * 为后续创建的用户生成一个count
     */
    @Insert("insert into user_count(time) values(now())")
    public void insertRegisterCount();

    /**
     * 为注册志愿者的人自动生成志愿者拓展信息表
     * @param userId 用户id
     * @return 插入的行数，一般为1
     */
    @Insert("insert into volunteer_info(user_id) values(#{userId})")
    public Integer volunteerAutoRegister(String userId);

    /**
     * 为注册ngo的机构自动生成ngo拓展信息表，并将状态生成为审核中
     * @param userId 用户Id
     * @return 插入的行数，一般为1
     */
    @Insert("insert into NGO_info(user_id) values(#{userId})")
    public Integer ngoAutoRegister(String userId);

    /**
     * 为注册街道的机构自动生成街道拓展信息表，并将状态生成为审核中
     * @param userId 用户Id
     * @return 插入的行数，一般为1
     */
    @Insert("insert into street_info(user_id) values(#{userId})")
    public Integer streetAutoRegister(String userId);

    /**
     * ngo拓展信息注册接口，因为已经自动生成表，所以改为修改信息（添加信息）
     * @param userId ngoID
     * @param introduce ngo介绍
     * @param location ngo位置
     * @param pictureUrl ngo图片url地址
     * @return 更改的行数，一般为1
     */
    @Update("update NGO_info " +
            "set ngo_introduce = #{introduce},ngo_location = #{location},ngo_picture = #{pictureUrl} " +
            "where user_id = #{userId}")
    public Integer ngoRegister(@Param("userId") String userId,@Param("introduce") String introduce,
                               @Param("location") String location,@Param("pictureUrl") String pictureUrl);

    /**
     * 街道拓展信息注册接口，因为已经自动生成表，所以改为修改信息（添加信息）
     * @param userId 街道ID
     * @param introduce 街道介绍
     * @param location 街道位置
     * @param pictureUrl 街道图片url地址
     * @return 更改的行数，一般为1
     */
    @Update("update street_info " +
            "set street_introduce = #{introduce},street_location = #{location},street_picture = #{pictureUrl} " +
            "where user_id = #{userId}")
    public Integer streetRegister(@Param("userId") String userId,@Param("introduce") String introduce,
                                  @Param("location") String location,@Param("pictureUrl") String pictureUrl);
}
