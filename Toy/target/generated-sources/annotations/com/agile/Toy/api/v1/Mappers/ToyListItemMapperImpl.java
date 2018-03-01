package com.agile.toy.api.v1.mappers;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.domains.Toy;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyDetailsDTO;
import com.agile.toy.api.v1.models.ToyListItemDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-03-01T11:54:25+0700",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
@Component
public class ToyListItemMapperImpl implements ToyListItemMapper {

    @Override
    public ToyListItemDTO convertToyDomainToToyListDto(Toy toy) {
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
    public ToyDetailsDTO convertToyDomainToToyDetailDto(Toy toy) {
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
    public CartEntitiesDTO convertCartDomainToCartDto(CartEntities cart) {
        if ( cart == null ) {
            return null;
        }

        CartEntitiesDTO cartEntitiesDTO = new CartEntitiesDTO();

        cartEntitiesDTO.setCartId( cart.getCartId() );
        cartEntitiesDTO.setToyId( cart.getToyId() );
        cartEntitiesDTO.setOrderQuantity( cart.getOrderQuantity() );

        return cartEntitiesDTO;
    }

    @Override
    public CartEntities convertCartDtoToCartDomain(CartEntitiesDTO cartEntitiesDTO) {
        if ( cartEntitiesDTO == null ) {
            return null;
        }

        CartEntities cartEntities = new CartEntities();

        cartEntities.setCartId( cartEntitiesDTO.getCartId() );
        cartEntities.setToyId( cartEntitiesDTO.getToyId() );
        cartEntities.setOrderQuantity( cartEntitiesDTO.getOrderQuantity() );

        return cartEntities;
    }
}
