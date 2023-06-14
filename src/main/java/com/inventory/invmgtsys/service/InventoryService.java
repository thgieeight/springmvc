package com.inventory.invmgtsys.service;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface InventoryService {

    List<InventoryDto> getInventoryList();
    InventoryDto addorUpdateInventory(InventoryDto inventoryDto);
    InventoryDto getInventoryById(Integer inventoryId);

    List<Map<String,String>>getInventoryList(Integer status);

    InventoryDto getInventoryByIdExceptionHandlingEg(Integer inventoryId) throws ResourceNotFoundException;


}