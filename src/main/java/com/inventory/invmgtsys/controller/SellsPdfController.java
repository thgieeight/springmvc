package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.service.SellsService;
import com.inventory.invmgtsys.utils.GenerateSellsPdf;
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
public class SellsPdfController {
    @Autowired
    SellsService sellsService;

    //https://www.baeldung.com/java-pdf-creation

    @GetMapping(value = "/sells-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport()
            throws IOException {
        List<SellsDto> sellsDtoList = (List<SellsDto>) sellsService.getSellsList();

        ByteArrayInputStream bis = GenerateSellsPdf.createSellsPdf(sellsDtoList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename=sells.pdf");
        return ResponseEntity.ok().headers(headers).contentType
                        (MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
