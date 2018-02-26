package com.agile.Toy.api.v1.Mappers;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToyListItemMapper {
    ToyListItemMapper INSTANCE = Mappers.getMapper(ToyListItemMapper.class);

    ToyListItemDTO ToyToToyListItemDTO(Toy toy);
}
