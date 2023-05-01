package com.shopping.agro.models;

import com.shopping.agro.entities.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

public class Product {

    private String productCode;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productImageUrl;
    private String productType;
    private String productCategory;
    private String productExpiryDate;
    private long productInStockCount;
    private boolean inStock;
    private String status;
    private MultipartFile multipartFile;
    public Product() {
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(String productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public long getProductInStockCount() {
        return productInStockCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", productType='" + productType + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productExpiryDate='" + productExpiryDate + '\'' +
                ", productInStockCount='" + productInStockCount + '\'' +
                '}';
    }

    public void setProductInStockCount(long productInStockCount) {
        this.productInStockCount = productInStockCount;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public ProductDTO mapToDTO(){
        ProductDTO dto = new ProductDTO();
        dto.setCategory(productCategory);
        dto.setInStock(true);
        dto.setProductDescription(productDescription);
        dto.setProductName(productName);
        dto.setProductImageUrl("/" + productCode);
        dto.setProductCode(productCode);
        dto.setProductPrice(productPrice);
        dto.setUnitsInStock(productInStockCount);
        dto.setProductType("E101");
        return dto;
    }
}
