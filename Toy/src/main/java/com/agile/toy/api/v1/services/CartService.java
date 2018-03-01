package com.agile.toy.api.v1.services;


import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyInCartDTO;

import java.util.List;

public interface CartService {
    CartEntitiesDTO addToCart(CartEntitiesDTO cartEntitiesDTO);

    List<ToyInCartDTO> getCartDetails(Long cartId);
}
