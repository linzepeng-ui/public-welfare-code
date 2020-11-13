package com.publicwelfare.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author zepeng.lin
 * @date 2020/10/20
 */
@Mapper
public interface MyWelfareMapper {

    /**
     * 志愿者我的公益查询
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl," +
            "service_status as serviceStatus,welfare_wealthy as welfareWealthy,service_person_num as servicePersonNum,service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info,service_persons \n" +
            "where basic_service_info.service_id = service_persons.service_id and service_persons.user_id = #{userId}")
    public List<Map<String,String>> volunteerList(@Param("userId") String userId);

    /**
     * 志愿者进行中公益
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl,\n" +
            "service_status as serviceStatus,welfare_wealthy as welfareWealthy,service_person_num as servicePersonNum,service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info,service_persons \n" +
            "where basic_service_info.service_id = service_persons.service_id and service_persons.user_id = #{userId} \n" +
            "having serviceStatus = '进行中'")
    public List<Map<String,String>> volunteerList1(@Param("userId") String userId);

    /**
     * 志愿者已完成公益
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl,\n" +
            "service_status as serviceStatus,welfare_wealthy as welfareWealthy,service_person_num as servicePersonNum,service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info,service_persons \n" +
            "where basic_service_info.service_id = service_persons.service_id and service_persons.user_id = #{userId} \n" +
            "having serviceStatus = '已完成'")
    public List<Map<String,String>> volunteerList2(@Param("userId") String userId);

    /**
     * 街道我的公益查询
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl,\n" +
            "service_status as serviceStatus,welfare_wealthy as welfareWealthy,service_person_num as servicePersonNum,service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info \n" +
            "where basic_service_info.service_from in (select user_name from user_info where user_id = #{userId})")
    public List<Map<String,String>> streetList(@Param("userId") String userId);

    /**
     * NGO我的公益查询
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl," +
            "service_status as serviceStatus,welfare_wealthy as welfareWealthy,service_person_num as servicePersonNum,service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info \n" +
            "where basic_service_info.execute_institution in (select user_name from user_info where user_id = #{userId})")
    public List<Map<String,String>> ngoList(@Param("userId") String userId);

    /**
     * NGO审核中列表
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl,\n" +
            "service_status as serviceStatus,basic_service_info.welfare_wealthy as welfareWealthy,basic_service_info.service_person_num as servicePersonNum,\n" +
            "basic_service_info.service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info,NGO_enter \n" +
            "where basic_service_info.service_id = NGO_enter.service_id and NGO_enter.user_id = #{userId} and NGO_enter.verify_status = '正在审核'")
    public List<Map<String,String>> ngoListBefore(@Param("userId") String userId);

    /**
     * NGO审核通过列表
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl,\n" +
            "service_status as serviceStatus,basic_service_info.welfare_wealthy as welfareWealthy,basic_service_info.service_person_num as servicePersonNum,\n" +
            "basic_service_info.service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info,NGO_enter \n" +
            "where basic_service_info.service_id = NGO_enter.service_id and NGO_enter.user_id = #{userId} and NGO_enter.verify_status = '审核通过'")
    public List<Map<String,String>> ngoListAfter(@Param("userId") String userId);

    /**
     * NGO审核未通过列表
     * @param userId 用户ID
     * @return
     */
    @Select("select basic_service_info.service_id as serviceId,basic_service_info.welfare_name as welfareName,basic_service_info.image_url as imageUrl,\n" +
            "service_status as serviceStatus,basic_service_info.welfare_wealthy as welfareWealthy,basic_service_info.service_person_num as servicePersonNum,\n" +
            "basic_service_info.service_help_person_num as serviceHelpPersonNum \n" +
            "from basic_service_info,NGO_enter \n" +
            "where basic_service_info.service_id = NGO_enter.service_id and NGO_enter.user_id = #{userId} and NGO_enter.verify_status = '审核失败'")
    public List<Map<String,String>> ngoListFailed(@Param("userId") String userId);
}
