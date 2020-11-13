package homepage.services.impl;

import homepage.mapper.HomeMapper;
import homepage.services.HomeService;
import org.springframework.stereotype.Service;
import parentpackage.entities.HomeSlideshow;
import parentpackage.entities.WelfareInfo;
import parentpackage.entities.common.CommonResult;
import parentpackage.entities.common.StatusCodeAndMsg;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    HomeMapper mapper;

    @Override
    public CommonResult getSlideshow() {
        List<HomeSlideshow> list = mapper.getSlide();
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult getNotice() {
        List<Map<String,String>> list = mapper.getNotice();
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult getOneNotice(String title) {
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",mapper.getOneNotice(title));
    }

    @Override
    public CommonResult getAllWelfareInfo() {
        List<Map<String,String>> list = mapper.getAllWelfare();
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult getOneWelfareInfo(String title) {
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",mapper.getOneWelfare(title));
    }

    @Override
    public CommonResult getNgoRank() {
        List<Map<String,String>> list = mapper.ngoRank();
        if(list.isEmpty()) {
            return new CommonResult(StatusCodeAndMsg.RESULT_NOT_FOUND,"没有数据哦");
        }
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",list);
    }

    @Override
    public CommonResult getOneNgoInfo(String userId) {
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",mapper.oneNgoInfo(userId));
    }

    @Override
    public CommonResult getVolunteerRank() {
        List<Map<String,String>> rankList = mapper.volunteerRank();
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",rankList);
    }

    @Override
    public CommonResult getOneVolunteerInfo(String userId) {
        return new CommonResult<>(StatusCodeAndMsg.SUCCESS_CODE,"查询成功",mapper.oneVolunteerInfo(userId));
    }

}
