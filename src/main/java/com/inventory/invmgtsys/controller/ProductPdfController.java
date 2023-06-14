package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.service.ProductService;
import com.inventory.invmgtsys.utils.GenerateProductPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ProductPdfController {
    @Autowired
    ProductService productService;

    //https://www.baeldung.com/java-pdf-creation

    @GetMapping(value = "/product-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport()
            throws IOException {
        List<ProductDto> productDtoList = (List<ProductDto>) productService.getProductList();

        ByteArrayInputStream bis = GenerateProductPdf.createProductPdf(productDtoList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename=categories.pdf");
        return ResponseEntity.ok().headers(headers).contentType
                        (MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
