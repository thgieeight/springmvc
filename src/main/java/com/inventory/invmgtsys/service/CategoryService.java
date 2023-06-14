package com.inventory.invmgtsys.service;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;

import java.util.List;

import java.util.Map;

public interface CategoryService {

    List<CategoryDto> getCategoryList();
    CategoryDto addorUpdateCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Integer categoryId);
    List<Map<String,String>>getCategoryList(Integer status);

    CategoryDto getCategoryByIdExceptionHandlingEg(Integer categoryId) throws ResourceNotFoundException;
}