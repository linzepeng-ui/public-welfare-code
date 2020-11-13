package com.publicwelfare.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * 主界面数据库操作映射
 * @author zepeng.lin
 * @date 2020/10/20
 */
@Mapper
public interface HomeMapper {

    /**
     * 通过用户ID查询用户类别
     * @param userId 用户ID
     * @return
     */
    @Select("select user_type as userType " +
            "from user_info " +
            "where user_id = #{userId}")
    public Map<String,String> selectUserTypeById(@Param("userId") String userId);

    /**
     * 获取街道已发布公益数和受益人数
     * @param userId 用户ID
     * @return
     */
    @Select("select count(*) as haveSendWelfare,sum(service_help_person_num) as serviceHelpPersonNum,sum(welfare_wealthy) as welfareWealthy \n" +
            "from basic_service_info \n" +
            "where service_from in(select user_name from user_info where user_id = #{userId})")
    public Map<String,String> selectStreetEveryWelfare(@Param("userId") String userId);

    /**
     * 获取街道已完成公益数
     * @param userId 用户ID
     * @return
     */
    @Select("select count(*) as haveDoneWelfare \n" +
            "from basic_service_info \n" +
            "where service_from in(select user_name from user_info where user_id = #{userId}) and service_status = '已完成';")
    public Map<String,String> selectStreetHaveDoneWelfare(@Param("userId") String userId);

    /**
     * 获取ngo已发布公益数和受益人数
     * @param userId 用户ID
     * @return
     */
    @Select("select count(*) as haveSendWelfare,sum(service_help_person_num) as serviceHelpPersonNum,sum(welfare_wealthy) as welfareWealthy \n" +
            "from basic_service_info \n" +
            "where execute_institution in(select user_name from user_info where user_id = #{userId})")
    public Map<String,String> selectNgoEveryWelfare(@Param("userId") String userId);

    /**
     * 获取ngo已完成公益数
     * @param userId 用户ID
     * @return
     */
    @Select("select count(*) as haveDoneWelfare \n" +
            "from basic_service_info \n" +
            "where execute_institution in(select user_name from user_info where user_id = #{userId}) and service_status = '已完成'")
    public Map<String,String> selectNgoHaveDoneWelfare(@Param("userId") String userId);

    /**
     * 查找志愿者已完成公益数
     * @param userId
     * @return
     */
    @Select("select volunteer_info.done_service as haveDoneWelfare \n" +
            "from volunteer_info \n" +
            "where volunteer_info.user_id = #{userId}")
    public Map<String,String> selectVolunteerDoneService(@Param("userId") String userId);

    /**
     * 查找志愿者已帮助人数
     * @param userId
     * @return
     */
    @Select("select count(*) as serviceHelpPersonNum \n" +
            "from volunteer_evaluation \n" +
            "where concrete_volunteer in(select user_name from user_info where user_id = #{userId})")
    public Map<String,String> selectVolunteerHelpPersonNum(@Param("userId") String userId);
}
