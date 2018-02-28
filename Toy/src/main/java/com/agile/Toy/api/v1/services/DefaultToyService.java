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

        List<Toy> toyList = toyListsRepository.getByGenderAndAge(convertGender(gender),convertAge(age));
        return toyList.stream()
                .map(toyListItemMapper::ToyToToyListItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ToyDetailsDTO getToyDetails(Long id) {

        return toyListItemMapper.ToyToToyDetailsDTO(toyListsRepository.findOne(id));
    }

    private String convertGender(String gender){
        if(isAll(gender))
            gender = "%";
        return gender;
    }

    private String convertAge(String age) {
        if (isAll(age)) {
            return "%";
        }
        else {
            Integer ageInt = Integer.parseInt(age);
            if (isBaby(ageInt))
                return "0";
            if (isToddler(ageInt))
                return "1";
            if (isThreeToFive(ageInt))
                return "3";
            if (isSixToEight(ageInt))
                return "6";
            else
                return "9";
        }
    }

    private boolean isAll(String age) {
        return age.equals("All");
    }

    private boolean isSixToEight(Integer ageInt) {
        return ageInt >= 5 && ageInt <= 8;
    }

    private boolean isThreeToFive(Integer ageInt) {
        return ageInt >= 3 && ageInt <= 5;
    }

    private boolean isToddler(Integer ageInt) {
        return ageInt >= 1 && ageInt < 3;
    }

    private boolean isBaby(Integer ageInt) {
        return ageInt < 1;
    }


}
