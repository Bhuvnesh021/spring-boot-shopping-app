package com.shopping.agro.entities;

import com.shopping.agro.models.Product;

import javax.persistence.*;

@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PRODUCT_DETAILS_ID")
    private Long id;
    @OneToOne
    private ProductDTO product;

    @Column(name = "NO_OF_QUANTITY")
    private int quantity;

    public ProductDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
