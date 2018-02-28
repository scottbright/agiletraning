package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Model.ToyDetailsDTO;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import java.util.List;


public interface ToyService {
    List<ToyListItemDTO> getToyFromGenderAndAge(String gender, String age);

    ToyDetailsDTO getToyDetails(Long id);
}
