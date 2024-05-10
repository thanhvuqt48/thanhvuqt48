/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }
    
    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }
    
    private Item getItemById(int id){
        for (Item i : items){
            if(i.getProduct().getId() == id){
                return i;
            }
        }
        return null;
    }
    
    public void addItem(Item t){
        if (getItemById(t.getProduct().getId()) != null){
            Item m = getItemById(t.getProduct().getId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }
    
    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id)); 
        }
    }
    
    public double getTotalMoney(){
        double t = 0;
        for(Item i : items){
            t +=  (i.getQuantity()*i.getPrice());
        }
        return t;
    }
    
    public Product getProductById(List<Product> list, int id){
        for (Product p : list){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public Cart(String txt, List<Product> list){
        items = new ArrayList<>();
        if (txt != null && txt.length() != 0){
            String[] ss = txt.split("/");
            for (String s : ss){
                String[] n = s.split(":");
                try {
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product p = getProductById(list, id);
                    Item i = new Item(p, quantity, p.getPrice()*3);
                    addItem(i);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
