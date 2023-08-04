package com.example.cacheableDemo.service;

import com.example.cacheableDemo.utils.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private CacheManager cacheManager;

    public String getCachedData() {

        if(cacheManager.getCache(GlobalVariables.BEARER_TOKEN_CACHE).get("token") != null) {
            System.out.println("Found in cache, returning ------>");
            return cacheManager.getCache(GlobalVariables.BEARER_TOKEN_CACHE).get("token").get().toString();
        }

        // If token not in cache, make call to acquire token
        String token = getBearerToken();

        if (token != null) {
            // If response from authentication service is not null, cache the token for reuse
            System.out.println("CACHING ----------->>>>");
            cacheManager.getCache(GlobalVariables.BEARER_TOKEN_CACHE).put("token", token);
        }else {
            System.out.println("Value was NULL, NOT Caching anything");
        }

        return token;
    }

    private String getBearerToken() {
        // Stub
        return "token";
    }
}
