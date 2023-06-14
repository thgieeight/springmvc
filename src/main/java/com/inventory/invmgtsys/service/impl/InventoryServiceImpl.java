package com.inventory.invmgtsys.service.impl;

import com.inventory.invmgtsys.converter.InventoryConverter;
import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;
import com.inventory.invmgtsys.model.Inventory;
import com.inventory.invmgtsys.model.Sells;
import com.inventory.invmgtsys.repo.InventoryRepo;
import com.inventory.invmgtsys.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;
    @Autowired
    InventoryConverter inventoryConverter;

    @Override
    public List<InventoryDto> getInventoryList() {


        return inventoryConverter.listEntityToDto(inventoryRepo.findAll());
    }

    @Override
    public InventoryDto addorUpdateInventory(InventoryDto inventoryDto)
    {

        Inventory inventory=inventoryConverter.inventoryDtoToInventoryEntity(inventoryDto);
        Inventory inventory1=inventoryRepo.save(inventory);
        InventoryDto inventoryDto1=inventoryConverter.inventoryEntityToInventoryDto(inventory1);
        return inventoryDto1;
    }

    @Override
    public InventoryDto getInventoryById(Integer inventoryId) {
        return inventoryConverter.inventoryEntityToInventoryDto(inventoryRepo.findById(inventoryId).get());
    }

    @Override
    public List<Map<String,String>> getInventoryList(Integer status) {
        return inventoryRepo.findEnabledProduct(status);
    }


    @Override
    public InventoryDto getInventoryByIdExceptionHandlingEg(Integer inventoryId) throws ResourceNotFoundException {
        InventoryDto inventoryDto=new InventoryDto();
        try {
            Optional<Inventory> inventory=inventoryRepo.findById(inventoryId);
            if(inventory.isPresent()){
                inventoryDto=inventoryConverter.inventoryEntityToInventoryDto(inventoryRepo.findById(inventoryId).get());
            }else {
                throw new ResourceNotFoundException("Inventory Not Found with id "+inventoryId);
            }


        }catch (Exception e){

        }
        return inventoryDto;
    }
}