package homepage.services;

import parentpackage.entities.common.CommonResult;

public interface WelfareService {

    /*
    NGO排名service
     */
    public CommonResult ngoEnter(String serviceId, String userId);

    /*
    Volunteer排名service
     */
    public CommonResult volunteerEnter(String serviceId, String userId);
}
