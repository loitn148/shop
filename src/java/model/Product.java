/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author loitn148
 */
public class Product {
    
    private long productId;
    private long categoryId;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDescription;
    private double productDiscount;
    private String productSlug;
    private Double productPriceSale;

    public Product() {
    }

    public Product(String productName, long categoryId, String productSlug, double productPrice, double productDiscount, String productDescription, String productImage, double productPriceSale) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productDiscount = productDiscount;
        this.productSlug = productSlug;
        this.productImage = productImage;
        this.productPriceSale = productPriceSale;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public void setProductSlug(String productSlug) {
        this.productSlug = productSlug;
    }

    public Double getProductPriceSale() {
        return productPriceSale;
    }

    public void setProductPriceSale(Double productPriceSale) {
        this.productPriceSale = productPriceSale;
    }
    
}
