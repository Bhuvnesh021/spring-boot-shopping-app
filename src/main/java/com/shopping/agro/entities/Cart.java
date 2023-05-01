package com.shopping.agro.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CART_ID")
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CART_PRODUCTS_DETAILS", joinColumns = @JoinColumn(name = "CART_ID"),
    inverseJoinColumns = @JoinColumn(name = "PRODUCT_DETAILS_ID"))
    private Set<ProductDetails> productDetailsSet;


    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProductDetails> getProductDetailsSet() {
        return productDetailsSet;
    }

    public void setProductDetailsSet(Set<ProductDetails> productDetailsSet) {
        this.productDetailsSet = productDetailsSet;
    }
}
