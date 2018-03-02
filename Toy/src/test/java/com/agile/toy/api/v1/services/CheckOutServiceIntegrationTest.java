package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import com.agile.toy.api.v1.repositories.CartEntriesViewRepository;
import com.agile.toy.api.v1.repositories.ToyListsRepository;
import com.agile.toy.bootstrap.Bootstrap;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("Test")
@Ignore
public class CheckOutServiceIntegrationTest {


    private CheckOutService checkOutService;

    private CartService cartService;

    private Bootstrap bootstrap;

    @Autowired
    private CartEntitiesRepository cartEntitiesRepository;

    @Autowired
    private ToyListsRepository toyListsRepository;

    @Autowired
    private CartEntriesViewRepository cartEntriesViewRepository;

    @Before
    public void setUp() throws Exception {
        bootstrap = new Bootstrap(toyListsRepository,cartEntitiesRepository,cartEntriesViewRepository);
        bootstrap.run();
        cartService = new DefaultCartService(cartEntitiesRepository, cartEntriesViewRepository, ToyListItemMapper.INSTANCE);
        checkOutService = new DefaultCheckOutService(toyListsRepository,ToyListItemMapper.INSTANCE,cartEntitiesRepository);
    }



}
