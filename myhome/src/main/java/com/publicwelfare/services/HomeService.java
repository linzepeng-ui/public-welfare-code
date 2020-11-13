package com.publicwelfare.services;

import parentpackage.entities.common.CommonResult;

/**
 * @author Administrator
 */
public interface HomeService {

    /**
     * 通过userID获取到userType
     * @param userId 用户ID
     * @return 用户类别字符串
     */
    public String getUserType(String userId);

    /**
     * 获取志愿者的服务统计信息
     * @param userId 用户ID
     * @return
     */
    public CommonResult getVolunteerInfo(String userId);

    /**
     * 获取NGO的服务统计信息
     * @param userId 用户ID
     * @return
     */
    public CommonResult getNgoInfo(String userId);

    /**
     * 获取街道的服务统计信息
     * @param userId 用户ID
     * @return
     */
    public CommonResult getStreetInfo(String userId);
}
