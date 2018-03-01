package com.agile.toy.api.v1.controllers;

import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {

        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public CartEntitiesDTO addToCart(@RequestBody CartEntitiesDTO cartEntitiesDTO){

        return cartService.addToCart(cartEntitiesDTO);
    }


}
