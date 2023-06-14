package com.inventory.invmgtsys.dto;

import com.inventory.invmgtsys.model.Inventory;
import com.inventory.invmgtsys.model.Product;

public class SellsDto {
    private Integer sellsId;

    private String customerName;

    private double sellQty;

    private String descriptionName;

    private String addedDate;
    private Integer status;
    private Inventory inventory;
    private Integer inventoryId;

    public Integer getSellsId() {
        return sellsId;
    }

    public void setSellsId(Integer sellsId) {
        this.sellsId = sellsId;
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

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
