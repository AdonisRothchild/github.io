package com.ad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @GetMapping("")
    public String test()
    {
        return "hello,world!";
    }
}
