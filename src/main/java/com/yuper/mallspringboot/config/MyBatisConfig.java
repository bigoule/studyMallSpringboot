package com.yuper.mallspringboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.yuper.mallspringboot.mbg.mapper", "com.yuper.mallspringboot.dao"})
public class MyBatisConfig {
}
