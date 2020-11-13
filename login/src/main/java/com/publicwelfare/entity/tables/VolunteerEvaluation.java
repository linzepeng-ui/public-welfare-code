package com.publicwelfare.entity.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 志愿者评价表
 */
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerEvaluation {

    /**
     * 评价ID号
     */
    private String evaluationId;

    /**
     * 服务完成时间
     */
    private String serviceDoEndTime;

    /**
     * 服务时长
     */
    private String serviceLongTimes;

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
     * 具体服务人员
     */
    private String concreteVolunteer;

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

    public String getServiceLongTimes() {
        return serviceLongTimes;
    }

    public void setServiceLongTimes(String serviceLongTimes) {
        this.serviceLongTimes = serviceLongTimes;
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

    public String getConcreteVolunteer() {
        return concreteVolunteer;
    }

    public void setConcreteVolunteer(String concreteVolunteer) {
        this.concreteVolunteer = concreteVolunteer;
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
        return "VolunteerEvaluation{" +
                "evaluationId='" + evaluationId + '\'' +
                ", serviceDoEndTime='" + serviceDoEndTime + '\'' +
                ", serviceLongTimes='" + serviceLongTimes + '\'' +
                ", serviceFrom='" + serviceFrom + '\'' +
                ", belongsNgo='" + belongsNgo + '\'' +
                ", concreteVolunteer='" + concreteVolunteer + '\'' +
                ", serviceForObject='" + serviceForObject + '\'' +
                ", evaluateReport=" + evaluateReport +
                '}';
    }
}
