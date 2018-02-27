package com.agile.Toy.api.v1.controllers;

import com.agile.Toy.api.v1.Model.ToyListDTO;
import com.agile.Toy.api.v1.services.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ToyController {


    private ToyService toyService;

    @Autowired
    public ToyController(ToyService toyService)
    {
        this.toyService = toyService;
    }
    @GetMapping
    public String hello(){
        return "hello world";
    }

    @GetMapping("/toyList")
    @ResponseStatus(HttpStatus.OK)
    public ToyListDTO getToyListByGenderAndAge(@RequestParam String gender,@RequestParam Integer age){
        return new ToyListDTO(toyService.getToyFromGenderAndAge(gender,age));
    }
}
