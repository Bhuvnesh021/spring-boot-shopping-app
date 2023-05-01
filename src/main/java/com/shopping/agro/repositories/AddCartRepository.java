package com.shopping.agro.repositories;

import com.shopping.agro.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddCartRepository extends CrudRepository<Cart, Long> {
}
