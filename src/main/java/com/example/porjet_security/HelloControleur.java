package com.example.porjet_security;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControleur {
    @GetMapping("/hello/public")
    public String helloPublic(){
        return "Hello public";
    }
    @GetMapping("/hello/private")
    public String helloPrivate(){
        return "Hello private";
    }
    @PostMapping("/hello/private")
    public String helloPrivatePost(){
        return "Hello private Post";
    }
}
