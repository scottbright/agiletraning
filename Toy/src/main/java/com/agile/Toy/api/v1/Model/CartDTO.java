package com.agile.Toy.api.v1.Model;

public class CartDTO {
    private Long CcrtId;
    private Long toyId;
    private String orderQuantity;

    public Long getCcrtId() {
        return CcrtId;
    }

    public void setCcrtId(Long ccrtId) {
        CcrtId = ccrtId;
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
