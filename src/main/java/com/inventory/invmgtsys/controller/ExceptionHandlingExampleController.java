package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.*;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;
import com.inventory.invmgtsys.service.CategoryService;
import com.inventory.invmgtsys.service.InventoryService;
import com.inventory.invmgtsys.service.ProductService;
import com.inventory.invmgtsys.service.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlingExampleController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    InventoryService inventoryService;


    @Autowired
    SellsService sellsService;


//
//    @PostMapping("/category-by-id")
//    public CategoryDto getCategoryDetail(RequestDto requestDto) throws ResourceNotFoundException {
//        System.out.println("req id"+requestDto.getCategoryId());
//        CategoryDto categoryDto=categoryService.getCategoryByIdExceptionHandlingEg(requestDto.getCategoryId());
//        System.out.println(categoryDto.toString());
//        return categoryDto;
//    }

    @GetMapping("/category-by-id/{categoryId}")
    public CategoryDto getCategoryDetail(@PathVariable("categoryId") Integer categoryId) throws ResourceNotFoundException {
        System.out.println("req id"+categoryId);
        CategoryDto categoryDto=categoryService.getCategoryByIdExceptionHandlingEg(categoryId);
        if(categoryDto.getCategoryId()==null){
            throw new ResourceNotFoundException("Category Not Found with id "+categoryId);
        }
        System.out.println(categoryDto.toString());
        return categoryDto;
    }

    @GetMapping("/product-by-id/{productId}")
    public ProductDto getProductDetail(@PathVariable("productId") Integer productId) throws ResourceNotFoundException {
        System.out.println("req id"+productId);
        ProductDto productDto=productService.getProductByIdExceptionHandlingEg(productId);
        if(productDto.getProductId()==null){
            throw new ResourceNotFoundException("Product Not Found with id "+productId);
        }
        System.out.println(productDto.toString());
        return productDto;
    }


    @GetMapping("/inventory-by-id/{inventoryId}")
    public InventoryDto getInventoryDetail(@PathVariable("inventoryId") Integer inventoryId) throws ResourceNotFoundException {
        System.out.println("req id"+inventoryId);
        InventoryDto inventoryDto=inventoryService.getInventoryByIdExceptionHandlingEg(inventoryId);
        if(inventoryDto.getInventoryId()==null){
            throw new ResourceNotFoundException("Inventory Not Found with id "+inventoryId);
        }
        System.out.println(inventoryDto.toString());
        return inventoryDto;
    }

    @GetMapping("/sells-by-id/{sellsId}")
    public SellsDto getSellsDetail(@PathVariable("sellsId") Integer sellsId) throws ResourceNotFoundException {
        System.out.println("req id"+sellsId);
        SellsDto sellsDto=sellsService.getSellsByIdExceptionHandlingEg(sellsId);
        if(sellsDto.getSellsId()==null){
            throw new ResourceNotFoundException("Sells Not Found with id "+sellsId);
        }
        System.out.println(sellsDto.toString());
        return sellsDto;
    }
}