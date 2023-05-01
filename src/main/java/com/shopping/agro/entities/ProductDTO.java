package com.shopping.agro.entities;

import com.shopping.agro.Constants;
import com.shopping.agro.models.Product;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "PRODUCT_CODE")
    private String productCode;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_DESC")
    private String productDescription;
    @Column(name = "PRODUCT_PRICE")
    private String productPrice;
    @Column(name = "PRODUCT_IMAGE_URL")
    private String productImageUrl;
    @Column(name = "PRODUCT_TYPE")
    private String productType;
    @Column(name = "IN_STOCK")
    private boolean inStock;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "UNITS_IN_STOCK")
    private long unitsInStock;

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
    public Product mapToModel(){
        Product product = new Product();
        product.setProductImageUrl(Constants.BASE_URL + Constants.PRODUCT_IMAGE_URL + productCode);
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductCode(productCode);
        product.setProductCategory(category);
        product.setProductInStockCount(unitsInStock);
        product.setProductType(productType);
        product.setProductPrice(productPrice);
        product.setInStock(inStock);
        product.setStatus(inStock ? "In stock" : "Out of stock");
        return product;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", productType='" + productType + '\'' +
                ", inStock=" + inStock +
                ", category='" + category + '\'' +
                ", unitsInStock=" + unitsInStock +
                '}';
    }
}
