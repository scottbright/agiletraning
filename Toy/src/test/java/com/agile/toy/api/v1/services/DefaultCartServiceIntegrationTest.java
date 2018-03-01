package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import com.agile.toy.bootstrap.Bootstrap;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DefaultCartServiceIntegrationTest {

    private CartService cartService;

    @Autowired
    private CartEntitiesRepository cartEntitiesRepository;

    @Before
    public void setUp(){
        cartService = new DefaultCartService(cartEntitiesRepository, ToyListItemMapper.INSTANCE);

    }

    @Test
    public void addToCartIntegrationTest(){
        CartEntitiesDTO cartEntitiesDTO = new CartEntitiesDTO();
        cartEntitiesDTO.setOrderQuantity(10);
        cartEntitiesDTO.setCartId(1L);
        cartEntitiesDTO.setToyId(1L);


        CartEntitiesDTO result = cartService.addToCart(cartEntitiesDTO);

        assertEquals(cartEntitiesDTO.getToyId(),result.getToyId());
        assertEquals(cartEntitiesDTO.getOrderQuantity(),result.getOrderQuantity());
        assertEquals(cartEntitiesDTO.getCartId(),cartEntitiesDTO.getCartId());

    }
}
