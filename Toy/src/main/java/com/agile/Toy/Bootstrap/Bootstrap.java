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
     /*  List<Toy> toyList = new ArrayList<>();

        Toy toy1 = new Toy();
        toy1.setToyName("43 Piece dinner set");
        toy1.setGender("Female");
        toy1.setAge("3_to_5");
        toy1.setPrice(12.95);
        toy1.setBrand("CoolKids");
        toy1.setQuantity(10);

        Toy toy2 = new Toy();
        toy2.setToyName("Eart DVD");
        toy2.setGender("Neutural");
        toy2.setAge("over8");
        toy2.setPrice(14.0);
        toy2.setBrand("CoolKids");
        toy2.setQuantity(20);

        Toy toy3 = new Toy();
        toy3.setToyName("new name");
        toy3.setGender("Male");
        toy3.setAge("3_to_5");
        toy3.setPrice(12.95);
        toy3.setBrand("CoolKids");
        toy3.setQuantity(10);

        Toy toy4 = new Toy();
        toy4.setToyName("new name2");
        toy4.setGender("Neutral");
        toy4.setAge("3_to_5");
        toy4.setPrice(12.95);
        toy4.setBrand("CoolKids");
        toy4.setQuantity(10);

        toyListsRepository.save(toy1);
        toyListsRepository.save(toy2);
        toyListsRepository.save(toy3);
        toyListsRepository.save(toy4);
        System.out.println("changg");*/

    }
}
