package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.CategoryDto;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/rest-template")
    public ResponseEntity<?> getCategories() {
        String categories = restTemplate.getForObject("http://localhost:8081/categories", String.class);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/add-category-rest-template")
    public ResponseEntity<?> addCategory() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


//        String plainCreds = "enterusername:enterpassword";
//        byte[] plainCredsBytes = plainCreds.getBytes();
//        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
//        String base64Creds = new String(base64CredsBytes);
//        headers.add("Authorization", "Basic " + base64Creds);

        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setCategoryName("computer");
        categoryDto.setCategoryId(1);
        categoryDto.setAddedDate("2020-02-01");
        categoryDto.setImage("computer.png");
        categoryDto.setStatus(1);
        categoryDto.setImage("computer.png");
        HttpEntity<CategoryDto> entity = new HttpEntity<>(categoryDto, headers);

        String categories = restTemplate.postForObject("http://localhost:8081/add-category",entity,String.class);

        JSONObject jsonObject=new JSONObject(categories);
        String categoryName=jsonObject.getString("categoryName");


        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}