package com.example.sfgdi.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHi(){
        System.out.println("sayHi called");

        return "Greetings!";
    }
}
