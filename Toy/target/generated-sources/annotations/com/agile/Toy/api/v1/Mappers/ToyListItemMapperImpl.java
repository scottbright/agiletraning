package com.agile.Toy.api.v1.Mappers;

import com.agile.Toy.api.v1.Domain.CartEntities;
import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Model.CartDTO;
import com.agile.Toy.api.v1.Model.ToyDetailsDTO;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-02-28T14:48:05+0700",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class ToyListItemMapperImpl implements ToyListItemMapper {

    @Override
    public ToyListItemDTO ToyToToyListItemDTO(Toy toy) {
        if ( toy == null ) {
            return null;
        }

        ToyListItemDTO toyListItemDTO = new ToyListItemDTO();

        toyListItemDTO.setId( toy.getId() );
        toyListItemDTO.setToyName( toy.getToyName() );
        toyListItemDTO.setBrand( toy.getBrand() );
        toyListItemDTO.setAge( toy.getAge() );
        toyListItemDTO.setGender( toy.getGender() );
        toyListItemDTO.setPrice( toy.getPrice() );
        toyListItemDTO.setAmountInStock( toy.getAmountInStock() );

        return toyListItemDTO;
    }

    @Override
    public ToyDetailsDTO ToyToToyDetailsDTO(Toy toy) {
        if ( toy == null ) {
            return null;
        }

        ToyDetailsDTO toyDetailsDTO = new ToyDetailsDTO();

        toyDetailsDTO.setId( toy.getId() );
        toyDetailsDTO.setToyName( toy.getToyName() );
        toyDetailsDTO.setBrand( toy.getBrand() );
        toyDetailsDTO.setAge( toy.getAge() );
        toyDetailsDTO.setGender( toy.getGender() );
        toyDetailsDTO.setPrice( toy.getPrice() );
        toyDetailsDTO.setAmountInStock( toy.getAmountInStock() );

        return toyDetailsDTO;
    }

    @Override
    public CartDTO CartToCartDTO(CartEntities cart) {
        if ( cart == null ) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();

        cartDTO.setCartId( cart.getCartId() );
        cartDTO.setToyId( cart.getToyId() );
        if ( cart.getOrderQuantity() != null ) {
            cartDTO.setOrderQuantity( String.valueOf( cart.getOrderQuantity() ) );
        }

        return cartDTO;
    }
}
