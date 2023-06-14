package com.inventory.invmgtsys.service;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductDto> getProductList();
    ProductDto addorUpdateProduct(ProductDto productDto);
    ProductDto getProductById(Integer productId);
    List<Map<String,String>>getProductList(Integer status);

    ProductDto getProductByIdExceptionHandlingEg(Integer productId) throws ResourceNotFoundException;


}
