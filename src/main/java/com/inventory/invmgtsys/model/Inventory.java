package com.inventory.invmgtsys.model;

import javax.persistence.*;

@Entity
@Table(name ="inventory_tbl")
public class Inventory {
    @Id
    @SequenceGenerator(name = "inventory_sequence",sequenceName = "inventory_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "inventory_sequence",strategy =GenerationType.SEQUENCE)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "inventory_name")
    private String inventoryName;

    @Column(name ="image")
    private String image;

    @Column(name="added_date")
    private String addedDate;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "CostPrice")
    private double costPrice;

    @Column(name = "SellPrice")
    private double sellPrice;
    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
}