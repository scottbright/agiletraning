package com.agile.Toy.api.v1.Repositories;

import com.agile.Toy.api.v1.Domain.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToyListsRepository extends JpaRepository<Toy,Long>{
   // @Query(value = "SELECT * FROM ToyLists where Age like :age and gender like :gender")
    List<Toy> getByGenderAndAge(String gender, String age);
}
