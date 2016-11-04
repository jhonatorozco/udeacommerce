/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controller;

import co.edu.udea.entity.Item;
import co.edu.udea.entity.Products;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author estudiantelis
 */
@ManagedBean(name="sp")
@SessionScoped
public class ShoppingCart {
    private List<Item> cart=new ArrayList<>();
    private double total;

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total=0;
        for(Item item:cart){
            total=total+(item.getQuantity()*item.getPr().getPrice().doubleValue());
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String addCart(Products p){
        for(Item item:cart){
            if(item.getPr().getId().equals(p.getId())){
                item.setQuantity(item.getQuantity()+1);
                return "cart";
            }
        }
        Item i=new Item();
        i.setQuantity(1);
        i.setPr(p);
        cart.add(i);
        return "cart";
    }
    
    public void update(){
        
    }
    
    public void remove(Item i){
        for(Item item:cart){
            if(item.equals(i)){
                cart.remove(item);
                break;
            }
        }
    }
    
    public String payment(){
        return "payment";
    }
    
}
