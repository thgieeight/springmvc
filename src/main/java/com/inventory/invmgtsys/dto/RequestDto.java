package com.inventory.invmgtsys.dto;

import com.inventory.invmgtsys.model.Inventory;

public class RequestDto {
    private Integer categoryId;
    private Integer productId;

    private Integer inventoryId;
    private Integer sellsId;
    private Integer userId;
    private Integer rolesId;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getSellsId() {
        return sellsId;
    }

    public void setSellsId(Integer sellsId) {
        this.sellsId = sellsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }
}
