package com.publicwelfare.entity;

import com.publicwelfare.mapper.WxStartMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 用于生成userId所使用的线程类
 * @author zepeng.lin
 * @date 2020/10/10
 */
public class CreateUserId implements Callable {

    private WxStartMapper mapper;

//    private Integer count = 0;

    public CreateUserId(WxStartMapper mapper) {
        this.mapper = mapper;
    }

    private String getDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    private synchronized Integer todayCount() {
        try {
            int count = mapper.getUserRegisterCount();
            mapper.insertRegisterCount();
            return count+1;
        } catch (NullPointerException e) {
            mapper.firstInsertRegisterCount();
            return 1;
        }
    }

    /**
     * 自动生成并获取当前用户注册数号码
     * @return count
     */
    private String getCount() {
        String str = "";
        int length = 0,number = todayCount();
        int thisNumber = number;
        while(number > 0) {
            number /= 10;
            length++;
        }
        switch (length) {
            case 1: str = "0000"+thisNumber;break;
            case 2: str = "000"+thisNumber;break;
            case 3: str = "00"+thisNumber;break;
            case 4: str = "0"+thisNumber;break;
            default: str = (Integer.toString(thisNumber));
        }
        return str;
    }

    @Override
    public Object call() {
        String userId = "";
        synchronized (this) {
            userId = this.getDate() + this.getCount();
        }
        try {
            Thread.sleep(10);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + userId);
        return userId;
    }
}
