package com.tinyurl.tinyURLApplication.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.tinyurl.tinyURLApplication.domain.entity.Url;
import com.tinyurl.tinyURLApplication.domain.repository.TinyUrlRepository;

public class UrlService {

    @Autowired
    public TinyUrlRepository tinyUrlRepository;

    public Url generateTinyUrl(String longUrl) {
        String key = UUID.randomUUID().toString();
        Url tinyUrl = new Url("http://localhost:8080/" + key, longUrl);
        tinyUrl.setKey(key);
        updateRedisCache(tinyUrl);
        return tinyUrl;
    }

    private void updateRedisCache(Url url) {
        tinyUrlRepository.save(url);
    }

    public String getLongUrl(String tinyUrl) {
        Url urlInstance = tinyUrlRepository.findUrl(tinyUrl);
        if (urlInstance != null) {
            return urlInstance.getLongUrl();
        }
        return "https://en.wikipedia.org/wiki/HTTP_404";
    }
}
