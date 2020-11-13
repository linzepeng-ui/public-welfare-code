package homepage.controllers;

import homepage.services.WelfareService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parentpackage.entities.common.CommonResult;


import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("WelfareInfo")
public class WelfareServController {

    @Resource
    WelfareService welfareService;


    @PostMapping("/NgoEnter")
    public CommonResult enterNgoMsg(@RequestParam(value = "serviceId")String serviceId, @RequestParam(value = "userId")String userId){
        return welfareService.ngoEnter(serviceId,userId);
    }


    @PostMapping("/VolunteerEnter")
    public CommonResult enterVolunteerMsg(@RequestParam(value = "serviceId")String serviceId, @RequestParam(value = "userId")String userId){
        return welfareService.volunteerEnter(serviceId,userId);
    }

}
