package com.publicwelfare.controllers.wxstage;

import com.publicwelfare.entity.*;
import com.publicwelfare.entity.tables.UserInfo;
import com.publicwelfare.mapper.WxStartMapper;
import com.publicwelfare.services.WxStartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.publicwelfare.entity.common.CommonResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * @author public-welfare
 * @date 2020/9/27
 * 微信小程序端登录和注册接口
 */
@RestController
@RequestMapping("/wxstart")
@Slf4j
public class WxStartController {

    @Resource
    private WxStartService service;

    @Autowired
    private FastDFSClient fastDfsClient;

//    private static final ExecutorService threadPool;
//
//    static {
//        int corePoolSize = Runtime.getRuntime().availableProcessors();
//        int maxPoolSize = Runtime.getRuntime().availableProcessors() * 2;
//        long keepAliveTime = 5;
//        TimeUnit keepAliveTimeUnit = TimeUnit.MINUTES;
//        int queSize = 100_000;
//        ThreadFactory threadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("ThreadPoolUtils")
//                .build();
//
//        threadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
//                keepAliveTime, keepAliveTimeUnit, new ArrayBlockingQueue<>(queSize)
//                , threadFactory);
//    }
//
//    /**
//     * 获取线程池
//     * @return 线程池
//     */
//    public static ExecutorService getThreadPool() {
//        return threadPool;
//    }

    /**
     * 微信小程序端登录接口
     * @param code 微信用户登录code
     * @return CommonResult 状态码 状态信息 数据
     */
    @PostMapping("/login")
    public CommonResult checkLogin(@RequestParam("code") String code) {
        return service.wxCheckLogin(code);
    }

    /**
     * 微信小程序端基本信息注册接口
     * @return CommonResult 状态码 状态信息 数据
     */
    @PostMapping("/register")
    public CommonResult normalRegister(@RequestBody UserInfo userInfo) throws ExecutionException, InterruptedException, IOException {
        System.out.println(userInfo.getUsername()+"\n"+userInfo.getOpenId()+"\n"+userInfo.getUserType()+"\n"+
                userInfo.getIdentifiedCardId()+"\n"+userInfo.getTelephoneNum()+"\n"+userInfo.getImageUrl()+"\n"+userInfo.getEmailAddr());
        return service.normalRegister(userInfo.getUsername(),userInfo.getOpenId(),userInfo.getUserType(),
                userInfo.getIdentifiedCardId(),userInfo.getTelephoneNum(),userInfo.getImageUrl(),userInfo.getEmailAddr());
    }

    /**
     * ngo拓展信息注册接口
     * @return CommonResult 状态码 状态信息 数据
     */
    @PostMapping("/ngo_register")
    public CommonResult ngoRegister(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file;
        try {
            file = req.getFile("ngoPicture");
        } catch (Exception e) {
            file = null;
        }
        return service.ngoRegister(request.getParameter("userId"),request.getParameter("ngoIntroduce"),request.getParameter("ngoLocation"),file);
    }

    /**
     * 街道拓展信息注册接口
     * @return CommonResult 状态码 状态信息 数据
     */
    @PostMapping("/street_register")
    public CommonResult streetRegister(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file;
        try {
            file = req.getFile("streetPicture");
        } catch (Exception e) {
            file = null;
        }
        return service.streetRegister(request.getParameter("userId"),request.getParameter("streetIntroduce"),request.getParameter("streetLocation"),file);
    }

    /**
     * fastDfs上传类
     * @param file 要上传的文件，一般是指图片
     * @return 图片的url地址
     * @throws IOException
     */
    @PostMapping("/upload_file")
    public String uploadFastDfs(@RequestParam(name = "image") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename()+"\n"+file.getContentType());
        return fastDfsClient.uploadFile(file);
    }



}
