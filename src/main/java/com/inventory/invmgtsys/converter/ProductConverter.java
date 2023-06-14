package com.inventory.invmgtsys.converter;

import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    public Product productDtoToProductEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setAddedDate(productDto.getAddedDate());
        product.setImage(productDto.getImage());
        product.setStatus(productDto.getStatus());
        product.setCategory(productDto.getCategory());
        return product;

    }
    public static ProductDto productEntityToProductDto(Product product){
        ProductDto productDto =new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setAddedDate(product.getAddedDate());
        productDto.setImage(product.getImage());
        productDto.setStatus(product.getStatus());
        productDto.setCategory(product.getCategory());
        return productDto;

    }

    public List<ProductDto> listEntityToDto(List<Product> products) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : products) {
            productDtoList.add(productEntityToProductDto(product));
        }
        return productDtoList;
    }

}
