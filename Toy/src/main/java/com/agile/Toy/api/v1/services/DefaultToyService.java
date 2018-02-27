package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Mappers.ToyListItemMapper;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DefaultToyService implements ToyService{

    ToyListsRepository toyListsRepository;
    ToyListItemMapper toyListItemMapper;

    @Autowired
    public DefaultToyService(ToyListsRepository toyListsRepository, ToyListItemMapper toyListItemMapper) {
        this.toyListsRepository = toyListsRepository;
        this.toyListItemMapper = toyListItemMapper;

    }

    @Override
    public List<ToyListItemDTO> getToyFromGenderAndAge(String gender,String age) {

        if(gender.equals("All"))
            gender = "%";

        List<Toy> toyList = toyListsRepository.getByGenderAndAge(gender,convertAge(age));
        System.out.println(toyList.size());
        return toyList.stream()
                .map(toyListItemMapper::ToyToToyListItemDTO)
                .collect(Collectors.toList());
    }

    private String convertAge(String age) {
        if (age.equals("All")) {
            return "%";
        }
        else {
            Integer ageInt = Integer.parseInt(age);
            if (ageInt < 1)
                return "Baby";
            if (ageInt >= 1 && ageInt < 3)
                return "Toddler";
            if (ageInt >= 3 && ageInt <= 5)
                return "3_to_5";
            if (ageInt >= 5 && ageInt <= 8)
                return "6_to_8";
            else
                return "over8";
        }
    }

}
