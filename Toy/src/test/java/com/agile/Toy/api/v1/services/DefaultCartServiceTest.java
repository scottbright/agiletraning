package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Model.CartDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultCartServiceTest {

    CartService cartService;

    @Before
    public void setUp(){
        cartService = new DefaultCartService();
    }
    @Test
    public void addToCartTest(){
        CartDTO cartDTO = new CartDTO();


    }

}