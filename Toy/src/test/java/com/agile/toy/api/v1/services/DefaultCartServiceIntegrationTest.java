package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyInCartDTO;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import com.agile.toy.api.v1.repositories.CartEntriesViewRepository;
import com.agile.toy.api.v1.repositories.ToyListsRepository;
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

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("Test")
public class DefaultCartServiceIntegrationTest {

    private CartService cartService;

    private Bootstrap bootstrap;

    @Autowired
    private CartEntitiesRepository cartEntitiesRepository;

    @Autowired
    private ToyListsRepository toyListsRepository;

    @Autowired
    private CartEntriesViewRepository cartEntriesViewRepository;

    @Before
    public void setUp() throws Exception {
        bootstrap = new Bootstrap(toyListsRepository,cartEntitiesRepository,cartEntriesViewRepository);
        bootstrap.run();
        cartService = new DefaultCartService(cartEntitiesRepository, cartEntriesViewRepository, ToyListItemMapper.INSTANCE);

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

    @Test
    public void getCartInfoTest(){
        Long cartId = 1L;

        List<ToyInCartDTO> resultToyList = cartService.getCartDetails(cartId);

        assertEquals(2,resultToyList.size());

    }
}
