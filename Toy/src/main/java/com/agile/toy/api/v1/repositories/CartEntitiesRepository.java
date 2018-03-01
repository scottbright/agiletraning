package com.agile.toy.api.v1.repositories;

import com.agile.toy.api.v1.domains.CartEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartEntitiesRepository extends JpaRepository<CartEntities,Long> {
}
