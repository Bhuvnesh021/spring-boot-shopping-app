package com.shopping.agro.services;

import com.shopping.agro.entities.Cart;
import com.shopping.agro.repositories.AddCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private AddCartRepository repository;
    @Override
    public List<Cart> findAll() {
        List<Cart> cartList = new ArrayList<>();
        repository.findAll().forEach(cartList::add);
        return cartList;
    }

    @Override
    public Optional<Cart> add(Cart cart) {
        return Optional.of(repository.save(cart));
    }
}
