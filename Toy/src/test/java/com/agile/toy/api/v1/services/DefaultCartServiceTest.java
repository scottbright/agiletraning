package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCartServiceTest {

    @Mock
    private CartEntitiesRepository cartEntitiesRepository;

    private CartService cartService;

    @Before
    public void setUp() {
        cartService = new DefaultCartService(cartEntitiesRepository, ToyListItemMapper.INSTANCE);
    }

    @Test
    public void addToCartTest() {

        CartEntitiesDTO cartEntitiesDTO = new CartEntitiesDTO();
        cartEntitiesDTO.setOrderQuantity(10);
        cartEntitiesDTO.setCartId(1L);
        cartEntitiesDTO.setToyId(1L);

        CartEntities cartEntities = new CartEntities();
        cartEntities.setId(1L);
        cartEntities.setCartId(1L);
        cartEntities.setOrderQuantity(10);

        when(cartEntitiesRepository.save(any(CartEntities.class))).thenReturn(cartEntities);

        CartEntitiesDTO result = cartService.addToCart(cartEntitiesDTO);

        assertEquals(cartEntitiesDTO.getCartId(), result.getCartId());
        assertEquals(cartEntitiesDTO.getOrderQuantity(),result.getOrderQuantity());
        assertEquals(cartEntities.getToyId(),result.getToyId());


    }

}