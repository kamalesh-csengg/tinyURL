package com.tinyurl.tinyURLApplication.domain.entity;

import java.io.Serializable;

public class Url implements Serializable {
    private String tinyUrl;
    private String longUrl;
    private String key;

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Url() {

    }

    public Url(String tinyUrl, String longUrl) {
        this.tinyUrl = tinyUrl;
        this.longUrl = longUrl;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Url [tinyUrl=");
        builder.append(tinyUrl);
        builder.append(", longUrl=");
        builder.append(longUrl);
        builder.append(", key=");
        builder.append(key);
        builder.append("]");
        return builder.toString();
    }
}