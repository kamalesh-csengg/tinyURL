package com.tinyurl.tinyURLApplication.domain.repository;

import org.springframework.stereotype.Repository;

import com.tinyurl.tinyURLApplication.domain.entity.Url;

@Repository
public interface TinyUrlRepository {
    
    void save(Url Url);
    
    Url findUrl(String key);
}
