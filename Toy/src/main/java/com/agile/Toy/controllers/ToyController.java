package com.agile.Toy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyController {

    @GetMapping
    public String hello(){
        return "hello world";
    }
}
