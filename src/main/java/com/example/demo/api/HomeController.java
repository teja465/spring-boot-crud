package com.example.demo.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String  HomePage(){
        return "hello , welcome to spring rest api demo crud app";
    }

}
