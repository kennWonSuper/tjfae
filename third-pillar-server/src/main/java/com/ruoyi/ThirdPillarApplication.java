package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 启动程序
 *
 * @author tjs
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ThirdPillarApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ThirdPillarApplication.class, args);
    }
}
