package com.mycompany.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  // Enable Spring Caching
public class RedisCachePocApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisCachePocApplication.class, args);
    }
}
