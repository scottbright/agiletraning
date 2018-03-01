package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.models.ToyListItemDTO;

public interface CheckOutService {

    ToyListItemDTO cutStock(Long toyId);

    void clearCart();
}
