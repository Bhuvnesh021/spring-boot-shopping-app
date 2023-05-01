package com.shopping.agro.services;

import com.shopping.agro.entities.ProductDTO;
import com.shopping.agro.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDTO> add(ProductDTO dto);
    Optional<ProductDTO> loadImage(String productImage);
    List<Product> loadAllProducts();
}
