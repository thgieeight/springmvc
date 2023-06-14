package com.inventory.invmgtsys.converter;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.model.Sells;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellsConverter {
    public Sells sellsDtoToSellsEntity(SellsDto sellsDto) {
        Sells sells = new Sells();
        sells.setSellsId(sellsDto.getSellsId());
        sells.setCustomerName(sellsDto.getCustomerName());
        sells.setAddedDate(sellsDto.getAddedDate());
        sells.setStatus(sellsDto.getStatus());
        sells.setSellQty(sellsDto.getSellQty());
        sells.setDescriptionName(sellsDto.getDescriptionName());
        sells.setInventory(sellsDto.getInventory());
        return sells;

    }
    public static SellsDto sellsEntityToSellsDto(Sells sells){
        SellsDto sellsDto =new SellsDto();
        sellsDto.setSellsId(sells.getSellsId());
        sellsDto.setCustomerName(sells.getCustomerName());
        sellsDto.setSellQty(sells.getSellQty());
        sellsDto.setDescriptionName(sells.getDescriptionName());
        sellsDto.setAddedDate(sells.getAddedDate());
        sellsDto.setStatus(sells.getStatus());
        sellsDto.setInventory(sells.getInventory());
        return sellsDto;

    }


    public List<SellsDto> listEntityToDto(List<Sells> sellss) {
        List<SellsDto> sellsDtoList = new ArrayList<>();
        for (Sells sells : sellss) {
            sellsDtoList.add(sellsEntityToSellsDto(sells));
        }
        return sellsDtoList;
    }
}
