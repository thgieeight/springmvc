package com.inventory.invmgtsys.model;

import javax.persistence.*;

@Entity
@Table(name ="sells_tbl")
public class Sells {
    @Id
    @SequenceGenerator(name = "sells_sequence",sequenceName = "sells_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "sells_sequence",strategy =GenerationType.SEQUENCE)
    @Column(name = "sells_id")
    private Integer sellsId;

    @Column(name = "customer_name")
    private String customerName;


    @Column(name="added_date")
    private String addedDate;

    @Column(name = "sell_qty")
    private double sellQty;

    @Column(name = "description_name")
    private String descriptionName;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name ="inventory_id")
    private Inventory inventory;

    public Integer getSellsId() {
        return sellsId;
    }

    public void setSellsId(Integer sellsId) {
        this.sellsId = sellsId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getSellQty() {
        return sellQty;
    }

    public void setSellQty(double sellQty) {
        this.sellQty = sellQty;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }
}
