package com.publicwelfare.entity.tables;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zepeng.lin
 * @date 2020/9/25
 * 服务详情表
 * 服务详情信息还待确认，所以此表暂时无字段
 */
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDetail {

    /**
     * 服务ID号
     */
    private String serviceId;

    /**
     * 服务时间
     */
    private String serviceTime;

    /**
     * 服务地点
     */
    private String servicePlace;

    /**
     * 服务描述
     */
    private String serviceIntroduce;

    /**
     * 图片地址
     */
    private String imageUrl;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getServicePlace() {
        return servicePlace;
    }

    public void setServicePlace(String servicePlace) {
        this.servicePlace = servicePlace;
    }

    public String getServiceIntroduce() {
        return serviceIntroduce;
    }

    public void setServiceIntroduce(String serviceIntroduce) {
        this.serviceIntroduce = serviceIntroduce;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ServiceDetail{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceTime='" + serviceTime + '\'' +
                ", servicePlace='" + servicePlace + '\'' +
                ", serviceIntroduce='" + serviceIntroduce + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
