package com.tinyurl.tinyURLApplication.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ConfigProvider {
    
    @Autowired
    private Environment env;

    public String getRedisIpAddress() {
        return env.getProperty("spring.redis.host");
    }

    public String getRedisPortNumber() {
        return env.getProperty("spring.redis.port");
    }

    public String getRedisCacheExpirationSeconds() {
        return env.getProperty("spring.redis.cache.expiration");
    }
}