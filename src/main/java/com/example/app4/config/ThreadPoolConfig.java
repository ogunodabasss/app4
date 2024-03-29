package com.example.app4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Primary
    @Bean("loggingThreadPoolExecutor")
    public ThreadPoolExecutor loggingThreadPoolExecutor() {
        return new ThreadPoolExecutor(10,20,10, TimeUnit.MINUTES,new LinkedBlockingQueue<>(),
                Thread.ofVirtual().name("logging-thread-pool").factory(), new ThreadPoolExecutor.AbortPolicy());
    }
}
