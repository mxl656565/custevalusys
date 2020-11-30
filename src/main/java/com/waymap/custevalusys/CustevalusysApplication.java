package com.waymap.custevalusys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.waymap.custevalusys.mapper")
@SpringBootApplication
public class CustevalusysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustevalusysApplication.class, args);
    }

}
