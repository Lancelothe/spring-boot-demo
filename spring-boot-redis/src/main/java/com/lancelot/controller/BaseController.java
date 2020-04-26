package com.lancelot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lancelot
 * @date 2020/4/26
 */
@RestController
public class BaseController {

    @GetMapping("/")
    public String hello() {
        return "hello world!";
    }
}
