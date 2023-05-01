package com.shopping.agro.repositories;

import com.shopping.agro.entities.ProductDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductDTO, Long> {
}
