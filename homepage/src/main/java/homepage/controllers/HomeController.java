package homepage.controllers;

import homepage.services.HomeService;
import org.springframework.web.bind.annotation.*;
import parentpackage.entities.common.CommonResult;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/homePage")
public class HomeController {

    @Resource
    HomeService service;

    /**
     * 首页轮播图
     * @throws IOException
     */
    @GetMapping("/get_slide_image")
    public CommonResult getSlide() {
        return service.getSlideshow();
    }

    @GetMapping("/get_notice")
    public CommonResult getHomeNotice() {
        return service.getNotice();
    }

    @GetMapping("/noticeByTitle")
    public CommonResult getOneHomeNotice(@RequestParam(name = "noticeTitle") String title) {
        return service.getOneNotice(title);
    }

    @GetMapping("/welfareInfoMsg")
    public CommonResult getAllWelfareInfo() {
        return service.getAllWelfareInfo();
    }

    @GetMapping("/welfareByTitle")
    public CommonResult getOneWelfareInfo(@RequestParam(name = "infoTitle") String title) {
        return service.getOneWelfareInfo(title);
    }

    @GetMapping("/ngoRank")
    public CommonResult ngoRank() {
        return service.getNgoRank();
    }

    @GetMapping("/ngoRank/{userId}")
    public CommonResult getNgoInfo(@PathVariable("userId") String userId) {
        return service.getOneNgoInfo(userId);
    }

    @GetMapping("/volunteerRank")
    public CommonResult volunteerRank() {
        return service.getVolunteerRank();
    }

    @GetMapping("/volunteerRank/{userId}")
    public CommonResult getOneVolunteerInfo(@PathVariable("userId") String userId) {
        return service.getOneVolunteerInfo(userId);
    }


}
