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
public class BillDetails {
    private long billDetailsID;
    private long billID;
    private long productID;
    private double price;
    private int quantity;

    public BillDetails() {
    }

    public BillDetails(long billID, long productID, double price, int quantity) {
        this.billID = billID;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public long getBillDetailsID() {
        return billDetailsID;
    }

    public void setBillDetailsID(long billDetailsID) {
        this.billDetailsID = billDetailsID;
    }

    public long getBillID() {
        return billID;
    }

    public void setBillID(long billID) {
        this.billID = billID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
