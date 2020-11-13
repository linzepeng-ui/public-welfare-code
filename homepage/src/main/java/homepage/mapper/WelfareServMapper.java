package homepage.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author Administrator
 */
@Mapper
public interface WelfareServMapper {

    /**
     *
     * @param serviceId 服务ID号
     * @param userId 用户ID号
     * @return
     */
    @Insert("INSERT INTO NGO_enter (service_id, user_id) VALUES (#{serviceId},#{userId})")
    public int insertNgo(@Param("serviceId") String serviceId, @Param("userId") String userId);

    /**
     *
     * @param serviceId 服务ID号
     * @param userId 用户ID号
     * @return
     */
    @Insert("INSERT INTO service_persons (service_id, user_id) VALUES (#{serviceId},#{userId})")
    public int insertVolunteer(@Param("serviceId") String serviceId, @Param("userId") String userId);

    /**
     * 查询服务需求人数
     * @param serviceId 服务ID
     * @return
     */
    @Select("select service_person_num as servicePersonNum " +
            "from basic_service_info " +
            "where service_id = #{serviceId}")
    public Map<String,Integer> servicePersonNum(@Param("serviceId") String serviceId);

    /**
     * 查询服务已参加人数
     * @param serviceId 服务ID
     * @return
     */
    @Select("select count(*) as serviceHavePersonNum " +
            "from service_persons " +
            "where service_id = #{serviceId}")
    public Map<String,Integer> serviceHavePersonNum(@Param("serviceId") String serviceId);
}
