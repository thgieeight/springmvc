package com.inventory.invmgtsys.service.impl;

import com.inventory.invmgtsys.converter.CategoryConverter;
import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;
import com.inventory.invmgtsys.model.Category;
import com.inventory.invmgtsys.repo.CategoryRepo;
import com.inventory.invmgtsys.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    CategoryConverter categoryConverter;

    @Override
    public List<CategoryDto> getCategoryList() {


        return categoryConverter.listEntityToDto(categoryRepo.findAll());
    }

    @Override
    public CategoryDto addorUpdateCategory(CategoryDto categoryDto)
    {

        Category category=categoryConverter.categoryDtoToCategoryEntity(categoryDto);
        Category category1=categoryRepo.save(category);
        CategoryDto categoryDto1=categoryConverter.categoryEntityToCategoryDto(category1);
        return categoryDto1;
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        return categoryConverter.categoryEntityToCategoryDto(categoryRepo.findById(categoryId).get());
    }

    @Override
    public List<Map<String,String>> getCategoryList(Integer status) {
        return categoryRepo.findEnabledCategory(status);
    }

    @Override
    public CategoryDto getCategoryByIdExceptionHandlingEg(Integer categoryId) throws ResourceNotFoundException {
        CategoryDto categoryDto=new CategoryDto();
        try {
            Optional<Category> category=categoryRepo.findById(categoryId);
            if(category.isPresent()){
                categoryDto=categoryConverter.categoryEntityToCategoryDto(categoryRepo.findById(categoryId).get());
            }else {
                throw new ResourceNotFoundException("Category Not Found with id "+categoryId);
            }


        }catch (Exception e){

        }
        return categoryDto;
    }
}