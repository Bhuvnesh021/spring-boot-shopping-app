package com.shopping.agro.services;



import com.shopping.agro.entities.ProductImages;

import java.util.Optional;

public interface ProductImageService {
    Optional<ProductImages> add(ProductImages productImages);

    Optional<ProductImages> loadImage(Long imageCode);
}
