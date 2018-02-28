package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Mappers.ToyListItemMapper;
import com.agile.Toy.api.v1.Model.ToyDetailsDTO;
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
import static org.mockito.Matchers.anyLong;
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
        String age = "0";

        Toy toy = new Toy();
        toy.setAge(age);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);


        when(toyListsRepository.getByGenderAndAge(any(String.class),any(String.class))).thenReturn(toys);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge(gender,"0");

        assertEquals("0",toyListItemDTO.get(0).getAge());
    }
    @Test
    public void getToyListItemByGenderAndAge3_to_5(){
        String gender = "Male";
        String age = "3";

        Toy toy = new Toy();
        toy.setAge(age);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);

        when(toyListsRepository.getByGenderAndAge(any(String.class),any(String.class))).thenReturn(toys);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge(gender,"3");

        assertEquals("3",toyListItemDTO.get(0).getAge());
    }
    @Test
    public void getToyListItemAllAgeAllGender(){
        String gender = "Female";
        String age = "3";

        Toy toy = new Toy();
        toy.setAge(age);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);



        when(toyListsRepository.getByGenderAndAge("%","%")).thenReturn(toys);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge("All","All");

        assertEquals("3",toyListItemDTO.get(0).getAge());
    }
    @Test
    public void getToyListItemLowerCase(){
        String gender = "Female";
        String age = "3";

        Toy toy = new Toy();
        toy.setAge(age);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy);


        when(toyListsRepository.getByGenderAndAge("%","%")).thenReturn(toys);

        List<ToyListItemDTO> toyListItemDTO = defaultToyService.getToyFromGenderAndAge("all","all");

        assertEquals("3",toyListItemDTO.get(0).getAge());
    }
    @Test
    public void getItemInfoTest(){
        Long id = 1L;

        Toy toy = new Toy();
        toy.setId(1L);

        when(toyListsRepository.findOne(anyLong())).thenReturn(toy);

        ToyDetailsDTO toyDetailsDTO = defaultToyService.getToyDetails(id);

        assertEquals(id,toyDetailsDTO.getId());

    }
}