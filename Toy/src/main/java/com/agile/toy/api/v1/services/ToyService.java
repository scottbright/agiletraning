package com.agile.toy.api.v1.services;

import com.agile.toy.api.v1.models.ToyDetailsDTO;
import com.agile.toy.api.v1.models.ToyListItemDTO;

import java.util.List;


public interface ToyService {
    List<ToyListItemDTO> getToyFromGenderAndAge(String gender, String age);

    ToyDetailsDTO getToyDetails(Long id);
}
