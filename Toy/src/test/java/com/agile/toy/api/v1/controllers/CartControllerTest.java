package com.agile.toy.api.v1.controllers;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.services.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {

    @MockBean
    private CartService cartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addToCartTest() throws Exception {

        CartEntitiesDTO cartEntitiesDTO = new CartEntitiesDTO();
        cartEntitiesDTO.setCartId(1L);
        cartEntitiesDTO.setToyId(1L);
        cartEntitiesDTO.setOrderQuantity(10);

        when(cartService.addToCart(any(CartEntitiesDTO.class))).thenReturn(cartEntitiesDTO);

        mockMvc.perform(post("/api/v1/addToCart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCoverter(cartEntitiesDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartId",equalTo(cartEntitiesDTO.getCartId().intValue())));


    }
    private String jsonCoverter(CartEntitiesDTO cartEntitiesDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cartEntitiesDTO);
    }
}
