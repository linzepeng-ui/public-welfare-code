package homepage.services;

import parentpackage.entities.common.CommonResult;

/**
 * @author Administrator
 */
public interface HomeService {

    public CommonResult getSlideshow();

    public CommonResult getNotice();

    public CommonResult getOneNotice(String title);

    public CommonResult getAllWelfareInfo();

    public CommonResult getOneWelfareInfo(String title);

    public CommonResult getNgoRank();

    public CommonResult getOneNgoInfo(String userId);

    public CommonResult getVolunteerRank();

    public CommonResult getOneVolunteerInfo(String userId);
}
