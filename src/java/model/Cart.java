/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author loitn148
 */
public class Cart {
    private HashMap<Long, Item> cartItem;

    public Cart() {
        this.cartItem = new HashMap<>();
    }

    public Cart(HashMap<Long, Item> cartItem) {
        this.cartItem = cartItem;
    }

    public HashMap<Long, Item> getCartItem() {
        return cartItem;
    }

    public void setCartItem(HashMap<Long, Item> cartItem) {
        this.cartItem = cartItem;
    }
    
    public void addToCart(Long key, Item item) {
        boolean check = cartItem.containsKey(key);
        if(check){
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartItem.put(key, item);
        } else {
            cartItem.put(key, item);
        }
        
    }
    
    public void updateCart(Long key, Item item) {
        boolean check = cartItem.containsKey(key);
        
        if(check){
            cartItem.put(key, item);
        }
    }
    
    public void removeToCart(Long key) {
        boolean check = cartItem.containsKey(key);
        
        if(check){
            cartItem.remove(key);
        }
    }
    
    public int countItem() {
        int count = 0;
        for(Map.Entry<Long, Item> list: cartItem.entrySet()){
            count += list.getValue().getQuantity();
        }
        return count;
    }
    
    public double totalCart(){
        double total = 0;
        for(Map.Entry<Long, Item> list: cartItem.entrySet()){
            total += list.getValue().getProduct().getProductPriceSale()*list.getValue().getQuantity();
        }
        return total;
    }
}
