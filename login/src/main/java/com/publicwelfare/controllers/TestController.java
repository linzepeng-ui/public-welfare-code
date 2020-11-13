package com.publicwelfare.controllers;

import com.publicwelfare.entity.FastDFSClient;
import com.publicwelfare.entity.tables.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author test
 */
@RestController
public class TestController {

    @Resource
    FastDFSClient fastDfsClient;

    @GetMapping("/test")
    public String test() {
        return "测试连接成功";
    }

    @PostMapping("test2")
    public String test2(@RequestBody LoginInfo loginInfo) {

        return loginInfo.getUserId()+loginInfo.getPassword();
    }

    @PostMapping("/test3")
    public String uploadFastDfs(@RequestParam(name = "image") MultipartFile file,
                                @RequestParam(name = "text") String text) throws IOException {
        System.out.println(file.getOriginalFilename()+"\n"+file.getContentType()+"\n"+text);
        System.out.println(file);
        String url;
        try {
             url = fastDfsClient.uploadFile(file);
        }catch (Exception e) {
            return "连接超时";
        }
        return url;
    }

    @PostMapping("/test4")
    public String uploadFileByWx(HttpServletRequest request) throws IOException {
        System.out.println(request.getParameter("name"));
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        System.out.println(file.getOriginalFilename()+" "+file.getContentType());
        return fastDfsClient.uploadFile(file)+"\n"+request.getParameter("name");
    }

}
