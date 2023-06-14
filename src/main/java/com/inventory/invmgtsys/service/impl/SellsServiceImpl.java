package com.inventory.invmgtsys.service.impl;


import com.inventory.invmgtsys.converter.SellsConverter;
import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;
import com.inventory.invmgtsys.model.Category;
import com.inventory.invmgtsys.model.Sells;
import com.inventory.invmgtsys.repo.SellsRepo;
import com.inventory.invmgtsys.service.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellsServiceImpl implements SellsService {

    @Autowired
    SellsRepo sellsRepo;
    @Autowired
    SellsConverter sellsConverter;

    @Override
    public List<SellsDto> getSellsList() {


        return sellsConverter.listEntityToDto(sellsRepo.findAll());
    }

    @Override
    public SellsDto addorUpdateSells(SellsDto sellsDto)
    {

        Sells sells=sellsConverter.sellsDtoToSellsEntity(sellsDto);
        Sells sells1=sellsRepo.save(sells);
        SellsDto sellsDto1=sellsConverter.sellsEntityToSellsDto(sells1);
        return sellsDto1;
    }

    @Override
    public SellsDto getSellsById(Integer sellsId) {
        return sellsConverter.sellsEntityToSellsDto(sellsRepo.findById(sellsId).get());
    }

    @Override
    public SellsDto getSellsByIdExceptionHandlingEg(Integer sellsId) throws ResourceNotFoundException {
        SellsDto sellsDto=new SellsDto();
        try {
            Optional<Sells> sells=sellsRepo.findById(sellsId);
            if(sells.isPresent()){
                sellsDto=sellsConverter.sellsEntityToSellsDto(sellsRepo.findById(sellsId).get());
            }else {
                throw new ResourceNotFoundException("Sells Not Found with id "+sellsId);
            }


        }catch (Exception e){

        }
        return sellsDto;
    }
}
