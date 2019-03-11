package com.tinyurl.tinyURLApplication.infra.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.tinyurl.tinyURLApplication.domain.entity.Url;
import com.tinyurl.tinyURLApplication.domain.repository.TinyUrlRepository;


@Repository
public class TinyUrlRepositoryImpl implements TinyUrlRepository {

    private static final String KEY = "urlKey";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @Autowired
    public TinyUrlRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }
    

    @Override
    public void save(Url url) {
        hashOperations.put(KEY, url.getKey(), url);
    }

    @Override
    public Url findUrl(String key) {
        return (Url) hashOperations.get(KEY, key);
    }

}