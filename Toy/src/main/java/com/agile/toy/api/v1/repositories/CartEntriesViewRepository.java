package com.agile.toy.api.v1.repositories;

import com.agile.toy.api.v1.domains.ToyInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartEntriesViewRepository extends JpaRepository<ToyInCart,Long> {

    @Query(value = "SELECT * FROM CartEntriesView where cartId =:cartId",nativeQuery = true)
    List<ToyInCart> getCart(@Param("cartId")Long cartId);
}
