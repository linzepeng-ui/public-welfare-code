package homepage.services.impl;

import homepage.mapper.WelfareServMapper;
import homepage.services.WelfareService;
import org.springframework.stereotype.Service;
import parentpackage.entities.common.CommonResult;
import parentpackage.entities.common.StatusCodeAndMsg;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class WelfareServiceImpl implements WelfareService {

    @Resource
    WelfareServMapper welfareServMapper;

    @Override
    public CommonResult ngoEnter(String serviceId, String userId) {
        int count;
        try {
            count = welfareServMapper.insertNgo(serviceId, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "您已经报名过啦");
        }
        if (count == 1) {
            return new CommonResult(StatusCodeAndMsg.SUCCESS_CODE, "报名成功，等待审核");
        } else {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "报名失败");
        }
    }

    @Override
    public CommonResult volunteerEnter(String serviceId, String userId) {
        Map<String,Integer> serviceNeedPersons = welfareServMapper.servicePersonNum(serviceId);
        Map<String,Integer> serviceHavePersons = welfareServMapper.serviceHavePersonNum(serviceId);
        if(serviceHavePersons.get("serviceHavePersonNum") >= serviceNeedPersons.get("servicePersonNum")) {
            return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "已经报名满啦");
        } else {
            int count;
            try {
                count = welfareServMapper.insertVolunteer(serviceId, userId);
            } catch (Exception e) {
                e.printStackTrace();
                return new CommonResult(StatusCodeAndMsg.REQUEST_ERROR, "您已经注册过啦");
            }
            if (count == 1) {
                return new CommonResult(StatusCodeAndMsg.SUCCESS_CODE, "报名成功");
            } else {
                return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND, "报名失败");
            }
        }
    }
}
