package com.agile.Toy.api.v1.Mappers;

import com.agile.Toy.api.v1.Domain.CartEntities;
import com.agile.Toy.api.v1.Model.CartDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CartMapper {
    CartDTO CartToCartDTO(CartEntities cart);
}
