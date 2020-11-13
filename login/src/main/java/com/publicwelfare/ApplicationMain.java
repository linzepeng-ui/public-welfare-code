package com.publicwelfare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author public-welfare
 * @date 2020/9/27
 */
@MapperScan("com.publicwelfare.mapper")
@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class,args);
    }
}
