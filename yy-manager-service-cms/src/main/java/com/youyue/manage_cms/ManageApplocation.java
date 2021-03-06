package com.youyue.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.youyue.framework.domain.cms")
@ComponentScan(basePackages = {"com.youyue.api","com.youyue.manage_cms"})
//@ComponentScan(basePackages = {"com.youyue.manage_cms"})
public class ManageApplocation {

    public static void main(String[] args) {
        SpringApplication.run(ManageApplocation.class);
    }
}
