package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RequestTypeExample2Controller {
//
//    List<ProductDto> productDtos = new ArrayList<>();
//    ProductDto productDto = new ProductDto(1, "productname", "product.png", "2022-01-02");
//    ResponseDto responseDto = new ResponseDto();
//
//
//    @GetMapping(value = "/all-product")
//    public ResponseEntity<?> getAllProduct() {
//        productDtos.add(productDto);
//        productDtos.add(productDto);
//        productDtos.add(productDto);
//        responseDto.setStatus(true);
//        responseDto.setMessage("product list");
//        responseDto.setData(productDtos);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/product/1
//    @GetMapping(value = "/product/{id}")
//    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
//        // ProductDto ProductDto = productDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);
//
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/product/1/Ram
//    @GetMapping(value = "/product/{id}/{name}")
//    public ResponseEntity<?> getProductByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//        // ProductDto ProductDto = productDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/product/id/1/name/bikash
//    //path variable with name
//    @GetMapping(value = "/product/id/{id}/name/{name}")
//    public ResponseEntity<?> getProductByIdAndNameNew(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//        // ProductDto ProductDto = productDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//    //using map to get value (use incase of mulitple parameteres)
////http://localhost:8084/product/1/Ram/Banepa
//    @GetMapping(value = "/product/{id}/{name}/{address}")
//    public ResponseEntity<?> getProductUsingMap(@PathVariable Map<String, String> pathVarsMap) {
//        // ProductDto ProductDto = productDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        String id = pathVarsMap.get("id");
//        String name = pathVarsMap.get("name");
//        String address = pathVarsMap.get("address");
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        System.out.println("address" + address);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //optional parameter in url
//    //http://localhost:8084/product1
//    //or
//    //http://localhost:8084/product1/1
//
//    @GetMapping(value = {"/product1", "/product1/{id}"})
//    public ResponseEntity<?> getProductByIdOptional(@PathVariable(value = "id", required = false) Integer id) {
//        // ProductDto ProductDto = productDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        //System.out.println("optional id"+id);
//
//        if (id != null) {
//            System.out.println("optional id" + id);
//        } else {
//            System.out.println("id null");
//        }
//
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //passing list in url
//
//    //http://localhost:8084/productList/1,2,3,4,5
//
//    @GetMapping(value = "/productList/{idList}")
//    public ResponseEntity<?> getProductListparameters(@PathVariable List<Integer> idList) {
//        // ProductDto ProductDto = productDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println(idList);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/product2?id=1
//    @GetMapping(value = "/product2")
//    public ResponseEntity<?> getProductByIdQueryParam(@RequestParam("id") Integer id) {
//        // ProductDto ProductDto = productDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println("Query param id" + id);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/product3?id=10&&name=Bikash
//    @GetMapping(value = "/product3")
//    public ResponseEntity<?> getProductByIdAndNameQueryParam(@RequestParam("id") Integer id, @RequestParam String name) {
//        // ProductDto ProductDto = productDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println("Query param id" + id);
//        System.out.println("Query param name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    @PostMapping
//    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
////localhost:8084/product/product/1
//
//    @PutMapping(value = "product/{id}")
//    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDto productDto) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //localhost:8084/product/1
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(productDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }


}
