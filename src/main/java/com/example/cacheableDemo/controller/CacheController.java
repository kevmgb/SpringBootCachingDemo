package com.example.cacheableDemo.controller;

import com.example.cacheableDemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CacheController {
    @Autowired
    MyService myService;

    @GetMapping("")
    public String testCache() {

        return myService.getCachedData();
    }
}
