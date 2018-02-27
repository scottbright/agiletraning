package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Mappers.ToyListItemMapper;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultToyServiceTest {
    private ToyService defaultToyService;

    @Mock
    private ToyListsRepository toyListsRepository;

    @Before
    public void setup(){

        defaultToyService = new DefaultToyService(toyListsRepository, ToyListItemMapper.INSTANCE);
    }

    @Test
    public void getToyListItemByGenderAndAgeLessThanOne(){
        String gender = "Male";
        String age = "Baby";

        Toy toy = new Toy();
        toy.setAge(age);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);


        when(toyListsRepository.getByGenderAndAge(gender,age)).thenReturn(toys);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge(gender,"0");

        assertEquals("Baby",toyListItemDTO.get(0).getAge());
    }
    @Test
    public void getToyListItemByGenderAndAge3_to_5(){
        String gender = "Male";
        String age = "3_to_5";

        Toy toy = new Toy();
        toy.setAge(age);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);


        when(toyListsRepository.getByGenderAndAge(gender,age)).thenReturn(toys);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge(gender,"4");

        assertEquals("3_to_5",toyListItemDTO.get(0).getAge());
    }
    @Test
    public void getToyListItemAllAgeAllGender(){
        String gender = "Female";
        String age = "3_to_5";

        Toy toy = new Toy();
        toy.setAge(age);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);


        when(toyListsRepository.getByGenderAndAge("%","%")).thenReturn(toys);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge("All","All");

        assertEquals("3_to_5",toyListItemDTO.get(0).getAge());
    }



}