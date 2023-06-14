package com.inventory.invmgtsys.controller;


import com.inventory.invmgtsys.dto.*;
import com.inventory.invmgtsys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    SellsService sellsService;


    @Autowired
    InvUserRoleService invUserRoleService;


    @Autowired
    InvUserService invUserService;


    @PostMapping("/category-detail")
    public CategoryDto getCategoryDetail(RequestDto requestDto){
        System.out.println("req id"+requestDto.getCategoryId());
        CategoryDto categoryDto=categoryService.getCategoryById(requestDto.getCategoryId());
        System.out.println(categoryDto.toString());
        return categoryDto;
    }

    @PostMapping("/product-detail")
    public ProductDto getProductDetail(RequestDto requestDto){
        System.out.println("req id"+requestDto.getProductId());
        ProductDto productDto=productService.getProductById(requestDto.getProductId());
        System.out.println(productDto.toString());
        return productDto;
    }

    @PostMapping("/enabled-category")
    public ResponseEntity<?> getEnabledCategory(){
        List<Map<String,String>> categoryDtoList=categoryService.getCategoryList(1);
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @PostMapping("/enabled-product")
    public ResponseEntity<?> getEnabledProduct(){
        List<Map<String,String>> productDtoList=productService.getProductList(1);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }


    @PostMapping("/enabled-inventory")
    public ResponseEntity<?> getEnabledInventory(){
        List<Map<String,String>> inventoryDtoList=inventoryService.getInventoryList(1);
        return new ResponseEntity<>(inventoryDtoList, HttpStatus.OK);
    }



    @PostMapping("/enabled-roles")
    public ResponseEntity<?> getEnabledRoles(){
        List<Map<String,String>> rolesDtoList=invUserRoleService.findEnabledRoles(true);
        return new ResponseEntity<>(rolesDtoList, HttpStatus.OK);
    }

    @PostMapping("/inventory-detail")
    public InventoryDto getInventoryDetail(RequestDto requestDto){
        System.out.println("req id"+requestDto.getInventoryId());
        InventoryDto inventoryDto=inventoryService.getInventoryById(requestDto.getInventoryId());
        System.out.println(inventoryDto.toString());
        return inventoryDto;
    }


    @PostMapping("/sells-detail")
    public SellsDto getSellsDetail(RequestDto requestDto){
        System.out.println("req id"+requestDto.getSellsId());
        SellsDto sellsDto=sellsService.getSellsById(requestDto.getSellsId());
        System.out.println(sellsDto.toString());
        return sellsDto;
    }

    @PostMapping("/user-detail")
    public UserDto getUserDetail(RequestDto requestDto){
        System.out.println("req id"+requestDto.getUserId());
        UserDto userDto=invUserService.getUserById(requestDto.getUserId());
        System.out.println(userDto.toString());
        return userDto;
    }


    @PostMapping("/role-detail")
    public RolesDto getRoleDetail(RequestDto requestDto){
        System.out.println("req id"+requestDto.getRolesId());
        RolesDto rolesDto=invUserRoleService.getRolesById(requestDto.getRolesId());
        System.out.println(rolesDto.toString());
        return rolesDto;
    }


}
