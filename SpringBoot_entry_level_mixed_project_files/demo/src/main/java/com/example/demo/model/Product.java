package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String name;
    private double unitPrice;
    private int avaible;
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @ManyToOne()
    @JoinColumn(name = "sellerId")
    private Seller seller;

    public Product(){}
    public Product(int productId, String name, double unitPrice, int avaible, Date addDate, Date updateDate) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.avaible = avaible;
        this.addDate = addDate;
        this.updateDate = updateDate;
    }

    public Product(String name, double unitPrice, int avaible, Date addDate, Date updateDate) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.avaible = avaible;
        this.addDate = addDate;
        this.updateDate = updateDate;
        //this.seller = seller;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAvaible() {
        return avaible;
    }

    public void setAvaible(int avaible) {
        this.avaible = avaible;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
