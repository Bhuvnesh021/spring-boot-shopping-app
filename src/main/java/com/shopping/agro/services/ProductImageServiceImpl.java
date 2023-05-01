package com.shopping.agro.services;

import com.shopping.agro.entities.ProductImages;
import com.shopping.agro.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;


    @Override
    public Optional<ProductImages> add(ProductImages productImages) {
        return Optional.of(productImageRepository.save(productImages));
    }

    @Override
    public Optional<ProductImages> loadImage(Long imageCode) {
        return productImageRepository.findById(imageCode);
    }


}
