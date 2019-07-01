/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author anita
 */
public class Shop {
    
    private int id;
    private String productName;
    private int price;
    private int discountPercentage;
    private String entryName;
    private String codePrice;
    
    public Shop(){
       }
    public Shop(int id, String productName, int price, int discountPercentage, String entryName, String codePrice){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.entryName = entryName;
        this.codePrice = codePrice;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }     
    public String getProductName(){
          return productName;   
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
   

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getCodePrice() {
        return codePrice;
    }

    public void setCodePrice(String codePrice) {
        this.codePrice = codePrice;
    }

    
    

}