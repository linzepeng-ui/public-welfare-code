package com.publicwelfare.controller;

import com.publicwelfare.services.EvaluationService;
import org.springframework.web.bind.annotation.*;
import parentpackage.entities.common.CommonResult;

import javax.annotation.Resource;

/**
 * NGO机构评分接口
 * @author zepeng.lin
 * @date 2020/10/19
 */
@RestController
@RequestMapping("/ngoEvaluation")
public class EvaluationController {

    @Resource
    EvaluationService service;

    @GetMapping("/beforeList/{streetId}")
    public CommonResult beforeNgoEvaluationList(@PathVariable(value = "streetId") String streetId) {
        return service.getEvaluationServiceList(streetId);
    }

    @GetMapping("/afterList/{streetId}")
    public CommonResult afterNgoEvaluationList(@PathVariable(value = "streetId") String streetId) {
        return service.getAfterEvaluationServiceList(streetId);
    }

    @PostMapping("/evaluation/{evaluationId}/{evaluationReport}")
    public CommonResult ngoEvaluation(@PathVariable(value = "evaluationId") String evaluationId,
                                      @PathVariable(value = "evaluationReport") float evaluationReport) {
        return service.ngoEvaluation(evaluationId,evaluationReport);
    }
}
