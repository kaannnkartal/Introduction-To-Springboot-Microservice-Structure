package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sellerId;
    private String sellerFirstName;
    private String sellerLastName;

    /*@OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "seller_product",joinColumns = @JoinColumn(name = "sellerId")
    , inverseJoinColumns = @JoinColumn(name = "product_id")) */
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private List<Product> products;


    public Seller(){}
    public Seller(String sellerFirstName, String sellerLastName) {
        this.sellerFirstName = sellerFirstName;
        this.sellerLastName = sellerLastName;
    }


    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
