package com.agile.Toy.api.v1.Mappers;

import com.agile.Toy.api.v1.Domain.CartEntities;
import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Model.CartDTO;
import com.agile.Toy.api.v1.Model.ToyDetailsDTO;
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
        toy.setToyName("Chan");
        toy.setAge("3_to_5");
        toy.setBrand("gg");
        toy.setGender("Male");
        toy.setPrice(123.45);

        ToyListItemDTO toyListItemDTO = toyListItemMapper.ToyToToyListItemDTO(toy);

        assertEquals(toy.getToyName(),toyListItemDTO.getToyName());
        assertEquals(toy.getAge(),toyListItemDTO.getAge());
        assertEquals(toy.getBrand(),toyListItemDTO.getBrand());
        assertEquals(toy.getGender(),toyListItemDTO.getGender());
        assertEquals(toy.getPrice(),toyListItemDTO.getPrice());
    }

    @Test
    public void ToyToToyDetailsDTO() {
        Toy toy = new Toy();
        toy.setId(1L);
        toy.setToyName("Chan");
        toy.setAge("3_to_5");
        toy.setBrand("gg");
        toy.setGender("Male");
        toy.setPrice(123.45);
        toy.setAmountInStock(10);

        ToyDetailsDTO toyListItemDTO = toyListItemMapper.ToyToToyDetailsDTO(toy);

        assertEquals(toy.getToyName(),toyListItemDTO.getToyName());
        assertEquals(toy.getAge(),toyListItemDTO.getAge());
        assertEquals(toy.getBrand(),toyListItemDTO.getBrand());
        assertEquals(toy.getGender(),toyListItemDTO.getGender());
        assertEquals(toy.getPrice(),toyListItemDTO.getPrice());
        assertEquals(toy.getId(),toyListItemDTO.getId());
        assertEquals(toy.getAmountInStock(),toyListItemDTO.getAmountInStock());
    }

    @Test
    public void CartToCartDTO() {
        CartEntities cart = new CartEntities();
        cart.setCartId(1l);
        cart.setId(1L);
        cart.setOrderQuantity(10);
        cart.setToyId(15l);

        CartDTO cartDTO = toyListItemMapper.CartToCartDTO(cart);
        assertEquals(cart.getCartId(),cartDTO.getCartId());
        assertEquals(cart.getOrderQuantity(),cartDTO.getOrderQuantity());
        assertEquals(cart.getToyId(),cartDTO.getToyId());
    }


}