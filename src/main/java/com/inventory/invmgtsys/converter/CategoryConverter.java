package com.inventory.invmgtsys.converter;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {
    public Category categoryDtoToCategoryEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        category.setAddedDate(categoryDto.getAddedDate());
        category.setImage(categoryDto.getImage());
        category.setStatus(categoryDto.getStatus());
        return category;

    }
    public CategoryDto categoryEntityToCategoryDto(Category category){
        CategoryDto categoryDto =new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setAddedDate(category.getAddedDate());
        categoryDto.setImage(category.getImage());
        categoryDto.setStatus(category.getStatus());
        return categoryDto;

    }


    public List<CategoryDto> listEntityToDto(List<Category> categories) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categories) {
            categoryDtoList.add(categoryEntityToCategoryDto(category));
        }
        return categoryDtoList;
    }

}