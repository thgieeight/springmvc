package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.converter.InventoryConverter;
import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.service.InventoryService;
import com.inventory.invmgtsys.service.SellsService;
import com.inventory.invmgtsys.utils.CommonUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;

import java.util.List;

@Controller
public class SellController {

    @Autowired
    SellsService sellsService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    InventoryConverter inventoryConverter;


    @GetMapping("/sells")
    public String getSells(Model model) {
        List<SellsDto> sellsDtoList = sellsService.getSellsList();
        model.addAttribute("sellsList", sellsDtoList);
        return "sells";
    }

    @PostMapping("/add-sells")

    public String addNewSells(@ModelAttribute("sells") SellsDto sellsDto, RedirectAttributes redirectAttributes) throws IOException {


            sellsDto.setAddedDate(CommonUtilities.getCurrentDateTime());

            InventoryDto inventoryDto=inventoryService.getInventoryById(sellsDto.getInventoryId());
            sellsDto.setInventory(inventoryConverter.inventoryDtoToInventoryEntity(inventoryDto));
        double quantity=inventoryDto.getQuantity();
        if(sellsDto.getSellQty()>quantity){
            redirectAttributes.addFlashAttribute("errorMessage","Salesquantity inventory Available quantity"+inventoryDto.getQuantity());
            return "redirect:/sells";
        }else{
            inventoryDto.setQuantity(inventoryDto.getQuantity()-sellsDto.getSellQty());
            inventoryService.addorUpdateInventory(inventoryDto);
        }

            sellsService.addorUpdateSells(sellsDto);

            return "redirect:/sells";

        }

    @PostMapping("/update-sells")
    public String updateSells(@ModelAttribute("sells") SellsDto sellsDto, RedirectAttributes redirectAttributes) throws IOException {

        SellsDto sellsDto1 = sellsService.getSellsById(sellsDto.getSellsId());

        sellsDto.setAddedDate(CommonUtilities.getCurrentDateTime());

        InventoryDto inventoryDto=inventoryService.getInventoryById(sellsDto.getInventoryId());
        sellsDto.setInventory(inventoryConverter.inventoryDtoToInventoryEntity(inventoryDto));
        double quantity=inventoryDto.getQuantity();
        if(sellsDto.getSellQty()>quantity){
            redirectAttributes.addFlashAttribute("errorMessage","Salesquantity inventory Available quantity"+inventoryDto.getQuantity());
            return "redirect:/sells";
        }else{
            inventoryDto.setQuantity(inventoryDto.getQuantity()-sellsDto.getSellQty());
            inventoryService.addorUpdateInventory(inventoryDto);
        }

        sellsService.addorUpdateSells(sellsDto);

        return "redirect:/sells";

    }
    @PostMapping("/delete-sells")
    public String deleteSells(@RequestParam("sellsId") Integer sellsId){
        System.out.println("delete controller sellsId"+sellsId);
        SellsDto sellsDto=sellsService.getSellsById(sellsId);
        sellsDto.setStatus(0);
        sellsService.addorUpdateSells(sellsDto);
        return "redirect:/sells";
    }

    }
