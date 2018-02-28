package com.agile.Toy.api.v1.Repositories;

import com.agile.Toy.api.v1.Domain.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToyListsRepository extends JpaRepository<Toy,Long>{

    @Query(value = "SELECT * FROM ToyLists where Age like :age and (Gender like :gender or Gender = 'Neutral')",nativeQuery = true)
    List<Toy> getByGenderAndAge(@Param("gender")String gender,@Param("age") String age);

}
