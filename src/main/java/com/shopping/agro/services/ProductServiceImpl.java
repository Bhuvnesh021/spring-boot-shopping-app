package com.shopping.agro.services;

import com.shopping.agro.entities.ProductDTO;
import com.shopping.agro.models.Product;
import com.shopping.agro.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository repository;
    @Override
    public Optional<ProductDTO> add(ProductDTO dto) {
        return Optional.of(repository.save(dto));
    }

    @Override
    public Optional<ProductDTO> loadImage(String productImage) {
        Iterable<ProductDTO> products = repository.findAll();
        Iterator<ProductDTO> iterator = products.iterator();
        if(iterator.hasNext()){
            ProductDTO productDTO = iterator.next();
        }
        return Optional.empty();
    }

    @Override
    public List<Product> loadAllProducts() {
        List<Product> productList = new ArrayList<>();
        Iterable<ProductDTO> all = repository.findAll();
        logger.debug("all : "+ all);
        Iterator<ProductDTO> iterator = all.iterator();
        logger.debug("iterator : "+ iterator);
        while (iterator.hasNext()){
            ProductDTO productDTO = iterator.next();
            logger.debug("productDTO : "+ productDTO);
            Product product = productDTO.mapToModel();
            productList.add(product);
        }
        return productList;
    }
}
