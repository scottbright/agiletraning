package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ToyService {
    List<ToyListItemDTO> getToyFromGenderAndAge(String gender, Integer age);
}
