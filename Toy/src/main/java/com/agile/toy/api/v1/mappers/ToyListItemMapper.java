package com.agile.toy.api.v1.mappers;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.domains.Toy;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyDetailsDTO;
import com.agile.toy.api.v1.models.ToyListItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToyListItemMapper {
    ToyListItemMapper INSTANCE = Mappers.getMapper(ToyListItemMapper.class);

    ToyListItemDTO convertToyDomainToToyListDto(Toy toy);

    ToyDetailsDTO convertToyDomainToToyDetailDto(Toy toy);

    CartEntitiesDTO convertCartDomainToCartDto(com.agile.toy.api.v1.domains.CartEntities cart);

    CartEntities convertCartDtoToCartDomain(CartEntitiesDTO cartEntitiesDTO);

}
