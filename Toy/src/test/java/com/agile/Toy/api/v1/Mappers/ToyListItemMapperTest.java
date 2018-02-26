package com.agile.Toy.api.v1.Mappers;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToyListItemMapperTest {

    private ToyListItemMapper toyListItemMapper;
    @Before
    public void setUp(){
        toyListItemMapper = toyListItemMapper.INSTANCE;
    }
    @Test
    public void ToyToToyListItem() {
        Toy toy = new Toy();
        toy.setName("Chan");
        toy.setAge(12);
        toy.setAvailability(true);
        toy.setBrand("gg");
        toy.setGender("Male");
        toy.setPrice(123.45);

        ToyListItemDTO toyListItemDTO = toyListItemMapper.ToyToToyListItemDTO(toy);

        assertEquals(toy.getName(),toyListItemDTO.getName());
        assertEquals(toy.getAge(),toyListItemDTO.getAge());
        assertEquals(toy.getAvailability(),toyListItemDTO.getAvailability());
        assertEquals(toy.getBrand(),toyListItemDTO.getBrand());
        assertEquals(toy.getGender(),toyListItemDTO.getGender());
        assertEquals(toy.getPrice(),toyListItemDTO.getPrice());
    }
}