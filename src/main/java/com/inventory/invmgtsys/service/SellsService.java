package com.inventory.invmgtsys.service;

import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;

import java.util.List;

public interface SellsService {
    List<SellsDto> getSellsList();
    SellsDto addorUpdateSells(SellsDto sellsDto);
    SellsDto getSellsById(Integer sellsId);

    SellsDto getSellsByIdExceptionHandlingEg(Integer sellsId) throws ResourceNotFoundException;

}
