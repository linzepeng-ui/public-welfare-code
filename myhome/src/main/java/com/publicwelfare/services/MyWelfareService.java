package com.publicwelfare.services;

import parentpackage.entities.common.CommonResult;

/**
 * @author zepeng.lin
 * @date 2020/10/20
 */
public interface MyWelfareService {

    /**
     * 我的公益清单列表
     * @param userId 用户ID
     * @return
     */
    public CommonResult myWelfareList(String userId);

    /**
     * 志愿者进行中列表
     * @param userId 用户ID
     * @return
     */
    public CommonResult volunteerList1(String userId);

    /**
     * 志愿者已完成列表
     * @param userId 用户ID
     * @return
     */
    public CommonResult volunteerList2(String userId);

    /**
     * ngo已报名但未审核列表
     * @param userId ngo ID
     * @return
     */
    public CommonResult ngoListBefore(String userId);

    /**
     * ngo已报名并审核完成列表
     * @param userId ngo ID
     * @return
     */
    public CommonResult ngoListAfter(String userId);

    /**
     * ngo报名失败并审核完成列表
     * @param userId ngo ID
     * @return
     */
    public CommonResult ngoListFailed(String userId);
}
