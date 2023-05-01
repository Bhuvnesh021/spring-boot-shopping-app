package com.shopping.agro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shopping.agro")
public class AgroApplication{

	public static void main(String[] args) {
		SpringApplication.run(AgroApplication.class, args);
	}


}
