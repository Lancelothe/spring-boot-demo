package com.lancelot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lancelot
 **/
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "hello world";
    }

}
