package com.example.cacheableDemo.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
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

    @Cacheable(value = "myCache", key = "#key")
    public String getCachedData(String key) {
        String result = someExpensiveOperation(key);
        if (result != null) {
            return result;
        }

        // If the result was null, manually evict the cache entry
        evictCacheEntry(key);

        return generateHelloOrNull();
    }

    @CacheEvict(value = "myCache", key = "#key")
    public void evictCacheEntry(String key) {
        // This method will manually evict the cache entry for the specified key
    }

    public String someExpensiveOperation(String key) {
        System.out.println("Ran here -------->");
        // Perform expensive computation
        return generateHelloOrNull();
    }

    public static String generateHelloOrNull() {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // Generates a random number between 1 and 10 (inclusive)

        if (randomNumber == 1 || randomNumber == 5 || randomNumber == 7 || randomNumber == 8) {
            System.out.println("generated hello");
            return "hello";
        } else {
            return null;
        }
    }
}
