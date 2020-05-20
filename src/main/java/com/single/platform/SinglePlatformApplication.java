package com.single.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SinglePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinglePlatformApplication.class, args);
    }

}
