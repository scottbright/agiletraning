package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.domains.ToyInCart;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyInCartDTO;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import com.agile.toy.api.v1.repositories.CartEntriesViewRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCartServiceTest {

    @Mock
    private CartEntitiesRepository cartEntitiesRepository;

    @Mock
    private CartEntriesViewRepository cartEntriesViewRepository;

    private CartService cartService;

    @Before
    public void setUp() {
        cartService = new DefaultCartService(cartEntitiesRepository, cartEntriesViewRepository,ToyListItemMapper.INSTANCE);
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

    @Test
    public void getCartInfoTest(){
        Long cartId = 1L;

        List<ToyInCart> toyInCartList = new ArrayList<>();
        ToyInCart toyInCart1 = new ToyInCart();
        ToyInCart toyInCart2 = new ToyInCart();
        toyInCartList.add(toyInCart1);
        toyInCartList.add(toyInCart2);

        when(cartEntriesViewRepository.getCart(any(Long.class))).thenReturn(toyInCartList);

        List<ToyInCartDTO> resultToyList = cartService.getCartDetails(cartId);

        assertEquals(2,resultToyList.size());

    }

}