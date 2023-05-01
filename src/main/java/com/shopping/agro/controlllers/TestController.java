package com.shopping.agro.controlllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class TestController {
    public String addProduct(){
        return "test success";
    }
}
