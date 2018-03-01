package com.agile.toy.api.v1.services;


import com.agile.toy.api.v1.domains.Toy;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.ToyListItemDTO;
import com.agile.toy.api.v1.repositories.ToyListsRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class DefaultCheckOutServiceTest {

    @Mock
    private ToyListsRepository toyListsRepository;

    private CheckOutService checkOutService;

    @Before
    public void setUp(){
        checkOutService = new DefaultCheckOutService(toyListsRepository, ToyListItemMapper.INSTANCE);
    }
    @Test
    public void stockCuttingTest(){
        Long toyId = 1L;

        Toy toy = new Toy();
        toy.setId(1L);
        toy.setAmountInStock(25);

        when(toyListsRepository.findOne(any(Long.class))).thenReturn(toy);

        Toy toy2 = new Toy();
        toy2.setId(1L);
        toy2.setAmountInStock(24);
        when(toyListsRepository.findOne(any(Long.class))).thenReturn(toy2);

        ToyListItemDTO afterCuttingStock = checkOutService.cutStock(toyId);

        assertEquals(toy.getAmountInStock().intValue()-1,afterCuttingStock.getAmountInStock().intValue());



    }

}