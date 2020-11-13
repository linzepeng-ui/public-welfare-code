package com.publicwelfare.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ConnectException;

@RestController
@RequestMapping("/activity")
public class ContractController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/queryWelfareTransaction")
    public String getQueryWelfareTransaction(HttpServletResponse response,
                                             @RequestParam("id") String id) throws IOException {
        String url = "https://www.linzepeng.icu:8081/activity/queryWelfareTransaction?id="+id;
//        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
//        map.add("id",1);
        ResponseEntity<String> text = null;
        try {
            text = restTemplate.exchange(url, HttpMethod.GET,null,String.class);
        } catch (Exception e) {
            return "服务器错误";
        }
        try {
            if(text.getStatusCode().is2xxSuccessful()) {
                return text.getBody();
            }
            return "请求失败";
        } catch (NullPointerException e) {
            return null;
        }
    }
}
