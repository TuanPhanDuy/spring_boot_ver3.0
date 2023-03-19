package com.springboot.restfulwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hellos")
public class HelloController {

    @GetMapping("hello-world-internationalized")
    public String helloWorldInternationalized(){
        return "Hello World";
    }
}
