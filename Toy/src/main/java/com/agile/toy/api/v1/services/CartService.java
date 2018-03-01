package com.agile.toy.api.v1.services;


import com.agile.toy.api.v1.models.CartEntitiesDTO;

public interface CartService {
    CartEntitiesDTO addToCart(CartEntitiesDTO cartEntitiesDTO);
}
