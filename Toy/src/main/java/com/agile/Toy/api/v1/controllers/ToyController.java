package com.agile.Toy.api.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyController {

    @GetMapping
    public String hello(){
        return "hello world";
    }
}
