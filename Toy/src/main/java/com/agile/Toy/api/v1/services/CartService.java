package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Model.CartDTO;

public interface CartService {
    CartDTO addToCart(CartDTO cartDTO);
}
