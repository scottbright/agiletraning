package com.agile.toy.api.v1.mappers;

import com.agile.toy.api.v1.models.CartEntitiesDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CartMapper {
    CartEntitiesDTO CartToCartDTO(com.agile.toy.api.v1.domains.CartEntities cart);
}
