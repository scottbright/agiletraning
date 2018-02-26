package com.agile.Toy.api.v1.Repositories;

import com.agile.Toy.api.v1.Domain.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToyListsRepository extends JpaRepository<Toy,Long>{
    List<Toy> getByGenderAndAge(String gender, Integer age);
}
