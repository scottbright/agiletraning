package com.agile.Toy.Bootstrap;


import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner{
    private ToyListsRepository toyListsRepository;

    @Autowired
    public Bootstrap(ToyListsRepository toyListsRepository){
        this.toyListsRepository = toyListsRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        List<Toy> toyList = new ArrayList<>();

        Toy toy1 = new Toy();
        toy1.setName("43 Piece dinner set");
        toy1.setGender("Female");
        toy1.setAge("3_to_5");
        toy1.setPrice(12.95);
        toy1.setAvailability("Instock");
        toy1.setBrand("CoolKids");

        Toy toy2 = new Toy();
        toy2.setName("Eart DVD");
        toy2.setGender("Neutural");
        toy2.setAge("over8");
        toy2.setPrice(14.0);
        toy2.setAvailability("SoldOut");
        toy2.setBrand("CoolKids");

        toyListsRepository.save(toy1);
        toyListsRepository.save(toy2);
        System.out.println("changg");

    }
}
