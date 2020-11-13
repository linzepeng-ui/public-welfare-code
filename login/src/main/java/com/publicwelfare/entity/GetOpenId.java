package com.publicwelfare.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.publicwelfare.entity.common.StatusCodeAndMsg;

/**
 * 获取微信小程序登录用户的openId
 * @author zepeng.lin
 * @date 2020/10/12
 */
public class GetOpenId {


    /**
     * 微信小程序AppId
     */
    public static String APP_ID = "wxf8d3e029ebed7428";

    /**
     * 微信小程序AppSecret
     */
    public static String APP_SECRET = "3570f3eed304c3b80f2cfb80c5293f21";

    private RestTemplate restTemplate;

    public GetOpenId(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 获取openID
     * @param code 微信登录code
     * @return 验证结果
     */
    public WxResult getOpenid(String code) {
        WxResult result = new WxResult();
        if(code == null) {
            result.setErrcode(StatusCodeAndMsg.RESULT_NOT_FOUND.toString());
            result.setErrmsg("no code");
            return result;
        }
        //微信那边的接口，grant_type=authorization_code是固定的
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+ APP_ID +
                "&secret="+APP_SECRET+"&js_code="+ code +"&grant_type=authorization_code";
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        System.out.println(results.getBody());
        JSONObject jsonObject = JSON.parseObject(results.getBody());
        result.setOpenid(jsonObject.getString("openid"));
        if(!"".equals(result.getOpenid()) || result.getOpenid() != null) {
            result.setErrcode("0");
            return result;
        }
        result.setErrcode(jsonObject.getString("errcode"));
        result.setErrcode(jsonObject.getString("errmsg"));
        return result;
    }
}
