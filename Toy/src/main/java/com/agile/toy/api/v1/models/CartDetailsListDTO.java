package com.agile.toy.api.v1.models;

import com.agile.toy.api.v1.domains.CartEntities;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartDetailsListDTO {

    private List<CartEntities> cartEntitiesList;

    @Autowired
    public CartDetailsListDTO(List<CartEntities> cartEntitiesList) {
        this.cartEntitiesList = cartEntitiesList;
    }

    public List<CartEntities> getCartEntitiesList() {
        return cartEntitiesList;
    }

    public void setCartEntitiesList(List<CartEntities> cartEntitiesList) {
        this.cartEntitiesList = cartEntitiesList;
    }
}
