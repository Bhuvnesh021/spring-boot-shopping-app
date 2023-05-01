package com.shopping.agro.controlllers;

import com.google.gson.Gson;
import com.shopping.agro.models.Product;
import com.shopping.agro.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Gson gson;
    @GetMapping(value = "/loadProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadProducts(){
        List<Product> productList = productService.loadAllProducts();
        return gson.toJson(productList);
    }
}
