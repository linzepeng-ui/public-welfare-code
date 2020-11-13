package com.publicwelfare.services;

import parentpackage.entities.common.CommonResult;

/**
 * @author Administrator
 */
public interface EvaluationService {

    /**
     * 获取某社区志愿服务下未评分的NGO机构列表
     * @param streetId 街道ID
     * @return
     */
    public CommonResult getEvaluationServiceList(String streetId);

    /**
     * 获取某社区志愿服务下已评分的NGO机构列表
     * @param streetId 街道ID
     * @return
     */
    public CommonResult getAfterEvaluationServiceList(String streetId);

    /**
     * 评价某个NGO的某个项目
     * @param evaluationId 评价ID
     * @param evaluationReport 平均评分
     * @return
     */
    public CommonResult ngoEvaluation(String evaluationId,float evaluationReport);
}
