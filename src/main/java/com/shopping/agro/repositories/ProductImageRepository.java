package com.shopping.agro.repositories;

import com.shopping.agro.entities.ProductImages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImages, Long> {
}
