package com.inventory.invmgtsys.converter;

import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryConverter {

    public Inventory inventoryDtoToInventoryEntity(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(inventoryDto.getInventoryId());
        inventory.setInventoryName(inventoryDto.getInventoryName());
        inventory.setAddedDate(inventoryDto.getAddedDate());
        inventory.setImage(inventoryDto.getImage());
        inventory.setStatus(inventoryDto.getStatus());
        inventory.setProduct(inventoryDto.getProduct());
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setCostPrice(inventoryDto.getCostPrice());
        inventory.setSellPrice(inventoryDto.getSellPrice());
        return inventory;

    }
    public static InventoryDto inventoryEntityToInventoryDto(Inventory inventory){
        InventoryDto inventoryDto =new InventoryDto();
        inventoryDto.setInventoryId(inventory.getInventoryId());
        inventoryDto.setInventoryName(inventory.getInventoryName());
        inventoryDto.setAddedDate(inventory.getAddedDate());
        inventoryDto.setImage(inventory.getImage());
        inventoryDto.setStatus(inventory.getStatus());
        inventoryDto.setProduct(inventory.getProduct());
        inventoryDto.setQuantity(inventory.getQuantity());
        inventoryDto.setCostPrice(inventory.getCostPrice());
        inventoryDto.setSellPrice(inventory.getSellPrice());
        //    inventoryDto.setCategoryId(inventory.());
        return inventoryDto;

    }


    public List<InventoryDto> listEntityToDto(List<Inventory> inventorys) {
        List<InventoryDto> inventoryDtoList = new ArrayList<>();
        for (Inventory inventory : inventorys) {
            inventoryDtoList.add(inventoryEntityToInventoryDto(inventory));
        }
        return inventoryDtoList;
    }

}