package homepage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import parentpackage.entities.HomeNotice;
import parentpackage.entities.HomeSlideshow;
import parentpackage.entities.UserInfo;
import parentpackage.entities.WelfareInfo;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Mapper
public interface HomeMapper {

    /**
     * 获取首页轮播图列表
     * @return
     */
    @Select("select * from home_slideshow")
    public List<HomeSlideshow> getSlide();

    /**
     * 获取首页公告标题和时间
     * @return
     */
    @Select("select notice_title as noticeTitle,notice_send_time as noticeSendTime \n" +
            "from home_notice \n" +
            "order by notice_send_time desc")
    public List<Map<String,String>> getNotice();

    /**
     * 一个公告
     * @param title
     * @return
     */
    @Select("select * from home_notice " +
            "where notice_title = #{title}")
    public HomeNotice getOneNotice(@Param(value = "title") String title);

    /**
     * 全部资讯
     * @return
     */
    @Select("select info_title as infoTitle,info_time as infoTime \n" +
            "from welfare_info \n" +
            "order by info_time desc")
    public List<Map<String,String>> getAllWelfare();

    /**
     * 一个资讯
     * @param title
     * @return
     */
    @Select("select * from welfare_info where info_title = #{title}")
    public WelfareInfo getOneWelfare(@Param(value = "title") String title);

    /**
     * ngo排名信息
     * @return
     */
    @Select("select user_info.user_id as userId,user_info.user_name as userName,user_info.image_url as imageUrl,NGO_info.comprehensive_score as comprehensiveScore \n" +
            "from user_info,NGO_info \n" +
            "where user_info.user_id = NGO_info.user_id order by NGO_info.comprehensive_score desc")
    public List<Map<String,String>> ngoRank();

    /**
     * 一个NGO排行中的详情信息
     * @param userId NGO ID
     * @return
     */
    @Select("select user_info.user_name as userName,user_info.telephone_num as telephoneNum,NGO_info.ngo_introduce as ngoIntroduce,NGO_info.ngo_picture as ngoPicture,\n" +
            "\tcount(distinct(service_persons.user_id)) as volunteerNum,count(distinct(basic_service_info.service_id)) as welfareNum \n" +
            "from service_persons,user_info,NGO_info,basic_service_info \n" +
            "where user_info.user_id = #{userId} and user_info.user_id = NGO_info.user_id and \n" +
            "\tuser_info.user_name = basic_service_info.execute_institution and basic_service_info.service_id = service_persons.service_id;")
    public Map<String,String> oneNgoInfo(@Param(value = "userId")String userId);

    /**
     * 志愿者排行信息，没有head_image
     * @return
     */
    @Select("select user_info.user_id as userId,user_info.user_name as userName,user_info.image_url as imageUrl,avg(volunteer_evaluation.evaluate_report) as evaluateReport,round(sum(volunteer_evaluation.service_long_times),1) as serviceLongTimes \n" +
            "from user_info,volunteer_evaluation \n" +
            "where user_info.user_name = volunteer_evaluation.concrete_volunteer \n" +
            "group by user_info.user_id \n" +
            "order by evaluateReport desc,serviceLongTimes desc")
    public List<Map<String,String>> volunteerRank();

    /**
     * 志愿者排行基本信息，get head_image and user_id
     * @return
     */
//    @Select("select user_info.user_id as userId,user_info.image_url as imageUrl\n" +
//            "from user_info\n" +
//            "where user_name in(select concrete_volunteer from volunteer_evaluation \n" +
//            "group by concrete_volunteer \n" +
//            "order by sum(service_long_times) desc)")
//    public List<Map<String,String>> volunteerUserInfoRank();

    /**
     * 一个volunteer的信息
     * @param userId 用户ID
     * @return
     */
    @Select("select * from user_info where user_id = #{userId}")
    public UserInfo oneVolunteerInfo(@Param(value = "userId")String userId);
}
