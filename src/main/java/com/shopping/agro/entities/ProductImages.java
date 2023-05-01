package com.shopping.agro.entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PRODUCT_IMAGE")
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Lob
    private byte[] content;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    public ProductImages() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "ProductImages{" +
                "id=" + id +
                ", content=" + Arrays.toString(content) +
                ", productName='" + productName + '\'' +
                '}';
    }
}
