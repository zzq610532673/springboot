package com.zzq.zzqproject;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzq.zzqproject.mapper")
public class ZzqprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzqprojectApplication.class, args);
    }

}
