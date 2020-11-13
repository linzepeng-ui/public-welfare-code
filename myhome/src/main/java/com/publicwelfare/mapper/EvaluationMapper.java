package com.publicwelfare.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * NGO评分数据库映射表
 * @author zepeng.lin
 * @date 2020/10/19
 */
@Mapper
public interface EvaluationMapper {

    /**
     * 查询街道审核状态，如果未审核则直接返回，不需继续进行下一步查询
     * @param streetId 街道id
     * @return
     */
    @Select("select street_status as status " +
            "from street_info " +
            "where user_id = #{streetId}")
    public Map<String,String> selectStreetStatus(@Param("streetId") String streetId);

    /**
     * 待评价列表
     * @param streetId 街道id
     * @return
     */
    @Select("select NGO_evaluation.evaluation_id as evaluationId,basic_service_info.welfare_name as welfareName,basic_service_info.service_from as serviceFrom,basic_service_info.execute_institution as executeInstitution,basic_service_info.image_url as imageUrl\n" +
            "from basic_service_info,NGO_evaluation\n" +
            "where basic_service_info.service_from in(select user_name from user_info where user_id = #{streetId}) \n" +
            "and basic_service_info.service_from = NGO_evaluation.service_from and NGO_evaluation.evaluate_report = 0 \n" +
            "and basic_service_info.execute_institution = NGO_evaluation.belongs_ngo and basic_service_info.service_status = '已完成'\n" +
            "order by NGO_evaluation.service_do_end_time asc;")
    public List<Map<String,String>> evaluationList(@Param("streetId") String streetId);

    /**
     * 已评价列表
     * @param streetId 街道id
     * @return
     */
    @Select("select NGO_evaluation.evaluation_id as evaluationId,basic_service_info.welfare_name as welfareName,basic_service_info.service_from as serviceFrom,basic_service_info.execute_institution as executeInstitution,basic_service_info.image_url as imageUrl,NGO_evaluation.evaluate_report as evaluationReport\n" +
            "from basic_service_info,NGO_evaluation\n" +
            "where basic_service_info.service_from in(select user_name from user_info where user_id = #{streetId}) \n" +
            "and basic_service_info.service_from = NGO_evaluation.service_from and NGO_evaluation.evaluate_report != 0 \n" +
            "and basic_service_info.execute_institution = NGO_evaluation.belongs_ngo and basic_service_info.service_status = '已完成'\n" +
            "order by NGO_evaluation.service_do_end_time asc;")
    public List<Map<String,String>> afterEvaluationList(@Param("streetId") String streetId);

    /**
     * 更新某项评分的评分信息
     * @param evaluationId 评价ID
     * @param evaluationReport 评价评分
     * @return
     */
    @Update("update NGO_evaluation " +
            "set evaluate_report = #{evaluationReport} " +
            "where evaluation_id = #{evaluationId}")
    public Integer updateNgoEvaluation(@Param("evaluationId") String evaluationId,@Param("evaluationReport") float evaluationReport);

    /**
     * 更新NGO机构的评价平均分
     * @param evaluationId 评价ID
     * @param evaluationReport 评价评分
     * @return
     */
    @Update("update NGO_info,NGO_evaluation,user_info \n" +
            "set NGO_info.comprehensive_score = \n" +
            "case when NGO_info.comprehensive_score = 0 then #{evaluationReport} \n" +
            "\t  when NGO_info.comprehensive_score != 0 then \n" +
            "\t  \t   (select sum(evaluate_report) from NGO_evaluation where belongs_ngo in(select belongs_ngo from NGO_evaluation where evaluation_id = #{evaluationId}) and evaluate_report != 0) / \n" +
            "\t  \t   (select count(*) from NGO_evaluation where belongs_ngo in(select belongs_ngo from NGO_evaluation where evaluation_id = #{evaluationId}) and evaluate_report != 0)\n" +
            "end\n" +
            "where NGO_info.user_id = user_info.user_id and NGO_evaluation.belongs_ngo = user_info.user_name and NGO_evaluation.evaluation_id = #{evaluationId}")
    public Integer updateNgoInfo(@Param("evaluationId") String evaluationId,@Param("evaluationReport") float evaluationReport);
}
