package com.agile.Toy.api.v1.services;

import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Mappers.ToyListItemMapper;
import com.agile.Toy.api.v1.Model.ToyDetailsDTO;
import com.agile.Toy.api.v1.Model.ToyListItemDTO;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public ToyDetailsDTO getToyDetails(Long id) {
        for(Toy toy : toyListsRepository.findAll()){
        }
        return toyListItemMapper.ToyToToyDetailsDTO(toyListsRepository.findOne(id));
    }

    private String convertAge(String age) {
        if (age.equals("All")) {
            return "%";
        }
        else {
            Integer ageInt = Integer.parseInt(age);
            if (ageInt < 1)
                return "0";
            if (ageInt >= 1 && ageInt < 3)
                return "1";
            if (ageInt >= 3 && ageInt <= 5)
                return "3";
            if (ageInt >= 5 && ageInt <= 8)
                return "6";
            else
                return "9";
        }
    }

}
