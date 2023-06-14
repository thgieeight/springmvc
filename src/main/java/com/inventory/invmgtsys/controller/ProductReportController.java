package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.service.ProductService;
import com.inventory.invmgtsys.utils.ProductExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ProductReportController {

    @Autowired
    ProductService productService;


    @GetMapping("/product/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=product_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<ProductDto> productDtoList = productService.getProductList();

        ProductExcelExporter excelExporter = new ProductExcelExporter(productDtoList);

        excelExporter.export(response);
    }

}
