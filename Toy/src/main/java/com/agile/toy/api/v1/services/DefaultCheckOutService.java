package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.domains.Toy;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.ToyListItemDTO;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import com.agile.toy.api.v1.repositories.ToyListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCheckOutService implements CheckOutService {

    private ToyListsRepository toyListsRepository;

    private ToyListItemMapper toyListItemMapper;

    private CartEntitiesRepository cartEntitiesRepository;

    @Autowired
    public DefaultCheckOutService(ToyListsRepository toyListsRepository,ToyListItemMapper toyListItemMapper,CartEntitiesRepository cartEntitiesRepository) {
        this.toyListsRepository = toyListsRepository;
        this.toyListItemMapper = toyListItemMapper;
        this.cartEntitiesRepository = cartEntitiesRepository;
    }

    @Override
    public ToyListItemDTO cutStock(Long toyId) {
        Toy toy = toyListsRepository.findOne(toyId);
        toy.setAmountInStock(toy.getAmountInStock()-1);
        System.out.println(toy.getAmountInStock());
        return toyListItemMapper.convertToyDomainToToyListDto(toyListsRepository.save(toy));
    }

    @Override
    public void clearCart() {
        cartEntitiesRepository.deleteAll();
    }

}
