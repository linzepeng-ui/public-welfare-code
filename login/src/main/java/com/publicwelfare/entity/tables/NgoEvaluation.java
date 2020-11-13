package com.publicwelfare.entity.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * NGO评价表
 */
@AllArgsConstructor
@NoArgsConstructor
public class NgoEvaluation {

    /**
     * 评价ID号
     */
    private String evaluationId;

    /**
     * 服务完成时间
     */
    private String serviceDoEndTime;

    /**
     * 服务来源
     * 这个服务来自于哪个街道
     */
    private String serviceFrom;

    /**
     * 所属NGO
     * 这个服务属于哪个NGO机构所管理
     */
    private String belongsNgo;

    /**
     * 服务人员名单
     */
    private String executors;

    /**
     * 服务对象
     */
    private String serviceForObject;

    /**
     * 服务评价反馈评分
     */
    private Float evaluateReport;

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getServiceDoEndTime() {
        return serviceDoEndTime;
    }

    public void setServiceDoEndTime(String serviceDoEndTime) {
        this.serviceDoEndTime = serviceDoEndTime;
    }

    public String getServiceFrom() {
        return serviceFrom;
    }

    public void setServiceFrom(String serviceFrom) {
        this.serviceFrom = serviceFrom;
    }

    public String getBelongsNgo() {
        return belongsNgo;
    }

    public void setBelongsNgo(String belongsNgo) {
        this.belongsNgo = belongsNgo;
    }

    public String getExecutors() {
        return executors;
    }

    public void setExecutors(String executors) {
        this.executors = executors;
    }

    public String getServiceForObject() {
        return serviceForObject;
    }

    public void setServiceForObject(String serviceForObject) {
        this.serviceForObject = serviceForObject;
    }

    public Float getEvaluateReport() {
        return evaluateReport;
    }

    public void setEvaluateReport(Float evaluateReport) {
        this.evaluateReport = evaluateReport;
    }

    @Override
    public String toString() {
        return "NgoEvaluation{" +
                "evaluationId='" + evaluationId + '\'' +
                ", serviceDoEndTime='" + serviceDoEndTime + '\'' +
                ", serviceFrom='" + serviceFrom + '\'' +
                ", belongsNgo='" + belongsNgo + '\'' +
                ", executors='" + executors + '\'' +
                ", serviceForObject='" + serviceForObject + '\'' +
                ", evaluateReport=" + evaluateReport +
                '}';
    }
}
