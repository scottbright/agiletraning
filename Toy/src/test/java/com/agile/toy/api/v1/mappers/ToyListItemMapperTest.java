package com.agile.toy.api.v1.mappers;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.domains.Toy;
import com.agile.toy.api.v1.domains.ToyInCart;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyDetailsDTO;
import com.agile.toy.api.v1.models.ToyInCartDTO;
import com.agile.toy.api.v1.models.ToyListItemDTO;
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

        ToyListItemDTO toyListItemDTO = toyListItemMapper.convertToyDomainToToyListDto(toy);

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

        ToyDetailsDTO toyListItemDTO = toyListItemMapper.convertToyDomainToToyDetailDto(toy);

        assertEquals(toy.getToyName(),toyListItemDTO.getToyName());
        assertEquals(toy.getAge(),toyListItemDTO.getAge());
        assertEquals(toy.getBrand(),toyListItemDTO.getBrand());
        assertEquals(toy.getGender(),toyListItemDTO.getGender());
        assertEquals(toy.getPrice(),toyListItemDTO.getPrice());
        assertEquals(toy.getId(),toyListItemDTO.getId());
        assertEquals(toy.getAmountInStock(),toyListItemDTO.getAmountInStock());
    }

    @Test
    public void CartDTOToCart() {
        CartEntitiesDTO cartEntitiesDTO = new CartEntitiesDTO();
        cartEntitiesDTO.setCartId(1L);
        cartEntitiesDTO.setOrderQuantity(10);
        cartEntitiesDTO.setToyId(15L);

        CartEntities cartEntities = toyListItemMapper.convertCartDtoToCartDomain(cartEntitiesDTO);
        assertEquals(cartEntities.getCartId(), cartEntitiesDTO.getCartId());
        assertEquals(cartEntities.getOrderQuantity(), cartEntitiesDTO.getOrderQuantity());
        assertEquals(cartEntities.getToyId(), cartEntitiesDTO.getToyId());
    }

    @Test
    public void ToyIncartToDtoTest(){
        ToyInCart toyInCart = new ToyInCart();
        toyInCart.setGender("male");
        ToyInCartDTO toyInCartDTO = toyListItemMapper.convertToyCartDomainToDto(toyInCart);
        assertEquals(toyInCart.getGender(),toyInCartDTO.getGender());

    }


}