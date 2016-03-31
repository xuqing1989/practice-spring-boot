package com.msi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/3/31.
 */
@RestController
public class Hello {
    @RequestMapping("/")
    public String index(){
        return "Hello World!";
    }
}
