package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Mappers.ToyListItemMapper;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class DefaultToyServiceTest {
    ToyService defaultToyService;
    ToyListsRepository toyListsRepository;

    @Before
    public void setup(){
        defaultToyService = new DefaultToyService(toyListsRepository, ToyListItemMapper.INSTANCE);
    }

    @Test
    public void getToyListItem(){
        String gender = "Male";
        Integer age = 12;

        Toy toy = new Toy();
        Toy toy2 = new Toy();
        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);
        toys.add(toy2);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge();

        when(toyListsRepository.getByGenderAndAge(gender,age)).thenReturn(toys);



    }

}