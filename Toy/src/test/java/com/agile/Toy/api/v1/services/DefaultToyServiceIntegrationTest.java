package com.agile.Toy.api.v1.services;

import com.agile.Toy.Bootstrap.Bootstrap;
import com.agile.Toy.ToyAppApplication;
import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Mappers.ToyListItemMapper;
import com.agile.Toy.api.v1.Model.ToyDetailsDTO;

import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
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

    @Before
    public void setup() throws Exception {
        bootstrap = new Bootstrap(toyListsRepository);
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
