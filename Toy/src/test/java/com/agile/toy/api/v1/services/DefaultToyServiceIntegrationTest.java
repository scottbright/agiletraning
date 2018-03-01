package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import com.agile.toy.bootstrap.Bootstrap;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.ToyDetailsDTO;

import com.agile.toy.api.v1.models.ToyListItemDTO;
import com.agile.toy.api.v1.repositories.ToyListsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("Test")
public class DefaultToyServiceIntegrationTest {
    private Bootstrap bootstrap;

    private ToyService toyService;
    @Autowired
    ToyListsRepository toyListsRepository;

    @Autowired
    CartEntitiesRepository cartEntitiesRepository;

    @Before
    public void setup() throws Exception {
        bootstrap = new Bootstrap(toyListsRepository,cartEntitiesRepository);
        bootstrap.run();

        toyService = new DefaultToyService(toyListsRepository, ToyListItemMapper.INSTANCE);
    }
    @Test
    public void getToyListItemByFemaleAndZero(){
        String gender = "Female";
        String age = "0";

        List<ToyListItemDTO> toyListItemDTOs= toyService.getToyFromGenderAndAge(gender,age);

        assertEquals(1,toyListItemDTOs.size());
        assertEquals("0",toyListItemDTOs.get(0).getAge());
    }

    @Test
    public void getToyListItemByFemaleAndSix(){
        String gender = "Female";
        String age = "6";

        List<ToyListItemDTO> toyListItemDTOs= toyService.getToyFromGenderAndAge(gender,age);

        assertEquals(1,toyListItemDTOs.size());
        assertEquals("6",toyListItemDTOs.get(0).getAge());
    }

    @Test
    public void getToyListItemByFemaleAndNine(){
        String gender = "Female";
        String age = "9";

        List<ToyListItemDTO> toyListItemDTOs= toyService.getToyFromGenderAndAge(gender,age);

        assertEquals(1,toyListItemDTOs.size());
        assertEquals("9",toyListItemDTOs.get(0).getAge());
    }
    @Test
    public void getToyListItemByAllGenderAge(){
        String gender = "All";
        String age = "All";

        List<ToyListItemDTO> toyListItemDTOs= toyService.getToyFromGenderAndAge(gender,age);

        assertEquals(5,toyListItemDTOs.size());

    }
    @Test
    public void getToyListItemByAllGenderAgeLowercase(){
        String gender = "alL";
        String age = "aLl";

        List<ToyListItemDTO> toyListItemDTOs= toyService.getToyFromGenderAndAge(gender,age);

        assertEquals(5,toyListItemDTOs.size());

    }
    @Test
    public void getToyDetailsByIdIntegrationTest(){
        Long id = 1L;
        ToyDetailsDTO toyDetailsDTO = toyService.getToyDetails(id);

        assertEquals(id,toyDetailsDTO.getId());

    }


}
