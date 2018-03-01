package com.agile.toy.api.v1.repositories;

import com.agile.toy.api.v1.domains.CartEntities;
import com.agile.toy.api.v1.models.ToyInCartDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartEntitiesRepository extends JpaRepository<CartEntities,Long> {

}
