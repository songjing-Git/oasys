package com.songjing.oasys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author songjing
 * @version 1.0
 */
@SpringBootApplication
@MapperScan("com.songjing.oasys.mapper")
public class OasysApplication {

    public static void main(String[] args) {
        SpringApplication.run(OasysApplication.class, args);
    }

}
