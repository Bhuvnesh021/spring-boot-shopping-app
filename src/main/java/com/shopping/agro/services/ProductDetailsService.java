package com.shopping.agro.services;

import com.shopping.agro.entities.ProductDetails;

import java.util.List;
import java.util.Optional;

public interface ProductDetailsService {
    List<ProductDetails> findAll();
    Optional<ProductDetails> add(ProductDetails productDetails);
}
