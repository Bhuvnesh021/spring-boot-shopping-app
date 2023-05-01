package com.shopping.agro.repositories;

import com.shopping.agro.entities.ProductDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends CrudRepository<ProductDetails, Long> {
}
