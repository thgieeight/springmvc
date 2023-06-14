package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.service.InventoryService;
import com.inventory.invmgtsys.utils.GenerateInventoryPdf;
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
public class InventoryPdfController {
    @Autowired
    InventoryService inventoryService;

    //https://www.baeldung.com/java-pdf-creation

    @GetMapping(value = "/inventory-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport()
            throws IOException {
        List<InventoryDto> inventoryDtoList = (List<InventoryDto>) inventoryService.getInventoryList();

        ByteArrayInputStream bis = GenerateInventoryPdf.createInventoryPdf(inventoryDtoList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename=categories.pdf");
        return ResponseEntity.ok().headers(headers).contentType
                        (MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
