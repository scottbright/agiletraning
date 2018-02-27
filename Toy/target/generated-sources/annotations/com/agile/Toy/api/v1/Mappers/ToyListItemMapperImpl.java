package com.agile.Toy.api.v1.Mappers;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-02-26T17:10:04+0700",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class ToyListItemMapperImpl implements ToyListItemMapper {

    @Override
    public ToyListItemDTO ToyToToyListItemDTO(Toy toy) {
        if ( toy == null ) {
            return null;
        }

        ToyListItemDTO toyListItemDTO = new ToyListItemDTO();

        toyListItemDTO.setName( toy.getName() );
        toyListItemDTO.setBrand( toy.getBrand() );
        toyListItemDTO.setAge( toy.getAge() );
        toyListItemDTO.setGender( toy.getGender() );
        toyListItemDTO.setAvailability( toy.getAvailability() );
        toyListItemDTO.setPrice( toy.getPrice() );

        return toyListItemDTO;
    }
}
