package com.agile.toy.api.v1.services;


import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.domains.Toy;
import com.agile.toy.api.v1.domains.ToyInCart;
import com.agile.toy.api.v1.mappers.ToyListItemMapper;
import com.agile.toy.api.v1.models.CartEntitiesDTO;
import com.agile.toy.api.v1.models.ToyInCartDTO;
import com.agile.toy.api.v1.repositories.CartEntitiesRepository;

import com.agile.toy.api.v1.repositories.CartEntriesViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCartService implements CartService{

    private CartEntitiesRepository cartEntitiesRepository;
    private ToyListItemMapper toyListItemMapper;
    private CartEntriesViewRepository cartEntriesViewRepository;

    @Autowired
    public DefaultCartService(CartEntitiesRepository cartEntitiesRepository, CartEntriesViewRepository cartEntriesViewRepository, ToyListItemMapper toyListItemMapper) {
        this.cartEntitiesRepository = cartEntitiesRepository;
        this.toyListItemMapper = toyListItemMapper;
        this.cartEntriesViewRepository = cartEntriesViewRepository;
    }

    @Override
    public CartEntitiesDTO addToCart(CartEntitiesDTO cartEntitiesDTO) {
        cartEntitiesDTO.setCartId(1L); //assigned mock cartId
        CartEntities cartEntities = cartEntitiesRepository.save(toyListItemMapper.convertCartDtoToCartDomain(cartEntitiesDTO));
        return toyListItemMapper.convertCartDomainToCartDto(cartEntities);
    }

    @Override
    public List<ToyInCartDTO> getCartDetails(Long cartId) {

        List<ToyInCart> toyList = cartEntriesViewRepository.getCart(cartId);
        return toyList.stream()
                .map(toyListItemMapper::convertToyCartDomainToDto)
                .collect(Collectors.toList());
    }
}
