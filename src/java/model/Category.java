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
public class Category {
    private long CatId;
    private long CatParentId;
    private String CatName;
    private String Slug;

    public Category() {
    }

    public Category(long CatParentId, String CatName, String Slug) {
        this.CatParentId = CatParentId;
        this.CatName = CatName;
        this.Slug = Slug;
    }

    public Category(String CatName, String Slug) {
        this.CatName = CatName;
        this.Slug = Slug;
    }
    
    public long getCatId() {
        return CatId;
    }

    public void setCatId(long CatId) {
        this.CatId = CatId;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String CatName) {
        this.CatName = CatName;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String Slug) {
        this.Slug = Slug;
    }

    public long getCatParentId() {
        return CatParentId;
    }

    public void setCatParentId(long CatParentId) {
        this.CatParentId = CatParentId;
    }
    
    
}
