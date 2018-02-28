package com.agile.Toy.api.v1.Mappers;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Model.ToyDetailsDTO;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-02-28T11:18:26+0700",
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
}
