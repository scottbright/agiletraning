package com.agile.toy.api.v1.services;


import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCartService implements CartService{

    private CartEntitiesRepository cartEntitiesRepository;
    private ToyListItemMapper toyListItemMapper;

    @Autowired
    public DefaultCartService(CartEntitiesRepository cartEntitiesRepository, ToyListItemMapper toyListItemMapper) {
        this.cartEntitiesRepository = cartEntitiesRepository;
        this.toyListItemMapper = toyListItemMapper;
    }

    @Override
    public CartEntitiesDTO addToCart(CartEntitiesDTO cartEntitiesDTO) {
        CartEntities cartEntities = cartEntitiesRepository.save(toyListItemMapper.convertCartDtoToCartDomain(cartEntitiesDTO));
        return toyListItemMapper.convertCartDomainToCartDto(cartEntities);
    }
}
