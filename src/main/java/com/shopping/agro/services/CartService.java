package com.shopping.agro.services;

import com.shopping.agro.entities.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> findAll();
    Optional<Cart> add(Cart cart);
}
