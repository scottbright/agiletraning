package com.agile.toy.api.v1.repositories;

import com.agile.toy.api.v1.domains.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToyListsRepository extends JpaRepository<Toy,Long>{

    @Query(value = "SELECT * FROM ToyLists where Age like :age and (Gender like :gender or Gender = 'Neutral')",nativeQuery = true)
    List<Toy> getByGenderAndAge(@Param("gender")String gender,@Param("age") String age);

}
