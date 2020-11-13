package com.publicwelfare.entity.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/10/9
 * NGO报名表
 */
@AllArgsConstructor
@NoArgsConstructor
public class NgoEnter {

    /**
     * 服务id号
     */
    private String serviceId;

    /**
     * 用户id号
     * 因为此表为NGO报名表，所以泛指NGO ID
     */
    private String userId;

    /**
     * 审核状态
     * 分为三种情况：“正在审核”，“审核失败”，“审核成功”
     */
    private String verifyStatus;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    @Override
    public String toString() {
        return "NgoEnter{" +
                "serviceId='" + serviceId + '\'' +
                ", userId='" + userId + '\'' +
                ", verifyStatus='" + verifyStatus + '\'' +
                '}';
    }
}
