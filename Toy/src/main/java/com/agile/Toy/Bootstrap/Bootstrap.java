package com.agile.Toy.Bootstrap;


import com.agile.Toy.api.v1.Domain.Toy;
import com.agile.Toy.api.v1.Repositories.ToyListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("Test")
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
        toy1.setToyName("43 Piece dinner set");
        toy1.setGender("female");
        toy1.setAge("3");
        toy1.setPrice(12.95);
        toy1.setBrand("CoolKids");
        toy1.setAmountInStock(10);

        Toy toy2 = new Toy();
        toy2.setToyName("Balance Training Bicycle");
        toy2.setGender("Neutral");
        toy2.setAge("3");
        toy2.setPrice(119.95);
        toy2.setBrand("SportsFun");
        toy2.setAmountInStock(21);

        Toy toy3 = new Toy();
        toy3.setToyName("Best Friends Forever Magnetic Dress Up");
        toy3.setGender("female");
        toy3.setAge("9");
        toy3.setPrice(24.95);
        toy3.setBrand("CoolKids");
        toy3.setAmountInStock(3);

        Toy toy4 = new Toy();
        toy4.setToyName("City Gargage Truck Lego");
        toy4.setGender("Neutral");
        toy4.setAge("0");
        toy4.setPrice(19.95);
        toy4.setBrand("CoolKids");
        toy4.setAmountInStock(0);

        Toy toy5 = new Toy();
        toy5.setToyName("Goumet Cupcake Baker");
        toy5.setGender("female");
        toy5.setAge("6");
        toy5.setPrice(19.95);
        toy5.setBrand("CoolKids");
        toy5.setAmountInStock(0);

        toyListsRepository.save(toy1);
        toyListsRepository.save(toy2);
        toyListsRepository.save(toy3);
        toyListsRepository.save(toy4);
        toyListsRepository.save(toy5);
        System.out.println("changg");

    }
}
