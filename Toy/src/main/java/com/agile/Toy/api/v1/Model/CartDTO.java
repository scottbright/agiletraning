package com.agile.Toy.api.v1.Model;

public class CartDTO {
    private Long cartId;
    private Long toyId;
    private String orderQuantity;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getToyId() {
        return toyId;
    }

    public void setToyId(Long toyId) {
        this.toyId = toyId;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
