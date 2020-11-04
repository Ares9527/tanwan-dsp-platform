package com.tanwan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tanwan.mapper")
public class MybatisPlusConfig {

}