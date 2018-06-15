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
public class ProductGallery {
    private long id;
    private long productId;
    private String imageGallery;

    public ProductGallery() {
    }

    public ProductGallery(long productId, String imageGallery) {
        this.productId = productId;
        this.imageGallery = imageGallery;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getImageGallery() {
        return imageGallery;
    }

    public void setImageGallery(String imageGallery) {
        this.imageGallery = imageGallery;
    }
    
    
}
