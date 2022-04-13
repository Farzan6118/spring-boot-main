package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
public class DataJpaTestTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaTestTwoApplication.class, args);
    }

}
