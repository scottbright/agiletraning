package com.agile.Toy.api.v1.controllers;

import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import com.agile.Toy.api.v1.services.DefaultToyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ToyController.class)
public class ToyControllerTest {
    @MockBean
    DefaultToyService defaultToyService;
    @Autowired
    MockMvc mvc;


    @Test
    public void getToyListTest() throws Exception {
        String gender = "Male";
        Integer age = 4;

        List<ToyListItemDTO> toyListItemDTOList = new ArrayList<>();

        ToyListItemDTO toyListItemDTO = new ToyListItemDTO();
        toyListItemDTO.setAge("3_to_5");
        toyListItemDTO.setAvailability("Instock");
        toyListItemDTO.setBrand("GG");
        toyListItemDTO.setGender(gender);

        toyListItemDTOList.add(toyListItemDTO);

        when(defaultToyService.getToyFromGenderAndAge(any(String.class),any(Integer.class))).thenReturn(toyListItemDTOList);

        mvc.perform(get("/api/v1/toyList?gender="+gender+"&age="+age)
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ToyList",hasSize(1)));
    }

}