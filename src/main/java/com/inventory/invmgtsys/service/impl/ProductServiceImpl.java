package com.inventory.invmgtsys.service.impl;
import com.inventory.invmgtsys.converter.ProductConverter;
import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.exceptionhandling.ResourceNotFoundException;
import com.inventory.invmgtsys.model.Product;
import com.inventory.invmgtsys.model.Sells;
import com.inventory.invmgtsys.repo.ProductRepo;
import com.inventory.invmgtsys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductConverter productConverter;

    @Override
    public List<ProductDto> getProductList() {


        return productConverter.listEntityToDto(productRepo.findAll());
    }

    @Override
    public ProductDto addorUpdateProduct(ProductDto productDto)
    {

        Product product=productConverter.productDtoToProductEntity(productDto);
        Product product1=productRepo.save(product);
        ProductDto productDto1=productConverter.productEntityToProductDto(product1);
        return productDto1;
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        return productConverter.productEntityToProductDto(productRepo.findById(productId).get());
    }
    @Override
    public List<Map<String,String>> getProductList(Integer status) {
        return productRepo.findEnabledProduct(status);
    }


    @Override
    public ProductDto getProductByIdExceptionHandlingEg(Integer productId) throws ResourceNotFoundException {
        ProductDto productDto=new ProductDto();
        try {
            Optional<Product> product=productRepo.findById(productId);
            if(product.isPresent()){
                productDto=productConverter.productEntityToProductDto(productRepo.findById(productId).get());
            }else {
                throw new ResourceNotFoundException("Sells Not Found with id "+productId);
            }


        }catch (Exception e){

        }
        return productDto;
    }
}
