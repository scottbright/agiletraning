package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Mappers.ToyListItemMapper;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;

import java.util.List;

public class DefaultToyService implements ToyService{

    public DefaultToyService(ToyListsRepository toyListsRepository, ToyListItemMapper toyListItemMapper) {
    }

    @Override
    public List<ToyListItemDTO> getToyFromGenderAndAge() {
        return null;
    }
}
