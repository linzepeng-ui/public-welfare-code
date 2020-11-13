package com.publicwelfare.entity.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 志愿者扩展信息表
 */
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerInfo {

    /**
     * 用户id(志愿者id)
     */
    private String userId;

    /**
     * 已完成服务数,数据库默认为0
     */
    private Integer doneService;

    /**
     * 累计积分数,数据库默认为0
     */
    private Integer accumulatedScore;

    /**
     * 剩余积分数,数据库默认为0
     */
    private Integer restScore;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDoneService() {
        return doneService;
    }

    public void setDoneService(Integer doneService) {
        this.doneService = doneService;
    }

    public Integer getAccumulatedScore() {
        return accumulatedScore;
    }

    public void setAccumulatedScore(Integer accumulatedScore) {
        this.accumulatedScore = accumulatedScore;
    }

    public Integer getRestScore() {
        return restScore;
    }

    public void setRestScore(Integer restScore) {
        this.restScore = restScore;
    }

    @Override
    public String toString() {
        return "VolunteerInfo{" +
                "userId='" + userId + '\'' +
                ", doneService=" + doneService +
                ", accumulatedScore=" + accumulatedScore +
                ", restScore=" + restScore +
                '}';
    }
}
