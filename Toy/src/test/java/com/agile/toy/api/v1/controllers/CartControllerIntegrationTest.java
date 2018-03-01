package com.agile.toy.api.v1.controllers;

import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyInCartDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.agile.toy.utilities.JsonCoverter.convertObjectToJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("Test")
public class CartControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void addToCartTest() throws Exception {

        CartEntitiesDTO cartEntitiesDTO = new CartEntitiesDTO();
        cartEntitiesDTO.setCartId(1L);
        cartEntitiesDTO.setToyId(1L);
        cartEntitiesDTO.setOrderQuantity(10);

        mockMvc.perform(post("/api/v1/addToCart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonString(cartEntitiesDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartId",equalTo(cartEntitiesDTO.getCartId().intValue())));
    }

    @Test
    public void getCartTest() throws Exception {
        Long cardId = 1L;

        mockMvc.perform(get("/api/v1/cart/"+cardId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));


    }
    @Test
    public void checkout() throws Exception {
        Long cardId = 1L;

        mockMvc.perform(get("/api/v1/checkout")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
