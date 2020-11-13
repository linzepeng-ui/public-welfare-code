package com.publicwelfare.services.impl;

import com.publicwelfare.mapper.EvaluationMapper;
import com.publicwelfare.services.EvaluationService;
import org.springframework.stereotype.Service;
import parentpackage.entities.common.CommonResult;
import parentpackage.entities.common.StatusCodeAndMsg;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Resource
    EvaluationMapper mapper;

    @Override
    public CommonResult getEvaluationServiceList(String streetId) {
        try {
            Map<String, String> selectStreetStatus = mapper.selectStreetStatus(streetId);
            if ("审核中".equals(selectStreetStatus.get("status"))) {
                return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "街道信息未审核");
            }
            List<Map<String, String>> evaluationList = mapper.evaluationList(streetId);
            if(evaluationList.isEmpty()) {
                return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "没有数据哦");
            }
            return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE, "查询成功", evaluationList);
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "没有数据哦");
        }
    }

    @Override
    public CommonResult getAfterEvaluationServiceList(String streetId) {
        try {
            Map<String, String> selectStreetStatus = mapper.selectStreetStatus(streetId);
            if ("审核中".equals(selectStreetStatus.get("status"))) {
                return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "街道信息未审核");
            }
            List<Map<String, String>> evaluationList = mapper.afterEvaluationList(streetId);
            if(evaluationList.isEmpty()) {
                return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "没有数据哦");
            }
            return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE, "查询成功", evaluationList);
        } catch (NullPointerException e) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "没有数据哦");
        }
    }

    @Override
    public CommonResult ngoEvaluation(String evaluationId, float evaluationReport) {
        //更新某个评价的评分
        Integer result = mapper.updateNgoEvaluation(evaluationId,evaluationReport);
        if(result == 1) {
            //更新NGO综合评分
            Integer result2 = mapper.updateNgoInfo(evaluationId,evaluationReport);
            if(result2 == 1) {
                return new CommonResult(StatusCodeAndMsg.SUCCESS_CODE, "更新成功");
            }
        }
        return new CommonResult(StatusCodeAndMsg.DATABASE_ERROR, "更新失败");
    }
}
