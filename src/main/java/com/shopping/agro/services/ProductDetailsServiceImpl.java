package com.shopping.agro.services;

import com.shopping.agro.entities.ProductDetails;
import com.shopping.agro.repositories.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService{
    @Autowired
    private ProductDetailsRepository repository;
    @Override
    public List<ProductDetails> findAll() {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        repository.findAll().forEach(productDetailsList :: add);
        return productDetailsList;
    }

    @Override
    public Optional<ProductDetails> add(ProductDetails productDetails) {
        return Optional.of(repository.save(productDetails));
    }
}
