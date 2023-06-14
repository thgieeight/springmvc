package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RequestTypeExampleController {
    List<CategoryDto> categoryDtos = new ArrayList<>();
    CategoryDto categoryDto = new CategoryDto(1, "categoryname", "category.png", "2022-01-02", 1);
    ResponseDto responseDto = new ResponseDto();


    @GetMapping(value = "/all-category")
    public ResponseEntity<?> getAllCategory() {
        categoryDtos.add(categoryDto);
        categoryDtos.add(categoryDto);
        categoryDtos.add(categoryDto);
        responseDto.setStatus(true);
        responseDto.setMessage("category list");
        responseDto.setData(categoryDtos);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //http://localhost:8084/category/1
    @GetMapping(value = "/category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);

        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //http://localhost:8084/category/1/Ram
    @GetMapping(value = "/category/{id}/{name}")
    public ResponseEntity<?> getCategoryByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);

        System.out.println("id" + id);
        System.out.println("name" + name);
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //http://localhost:8084/category/id/1/name/bikash
    //path variable with name
    @GetMapping(value = "/category/id/{id}/name/{name}")
    public ResponseEntity<?> getCategoryByIdAndNameNew(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);

        System.out.println("id" + id);
        System.out.println("name" + name);
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    //using map to get value (use incase of mulitple parameteres)
//http://localhost:8084/category/1/Ram/Banepa
    @GetMapping(value = "/category/{id}/{name}/{address}")
    public ResponseEntity<?> getCategoryUsingMap(@PathVariable Map<String, String> pathVarsMap) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
        String id = pathVarsMap.get("id");
        String name = pathVarsMap.get("name");
        String address = pathVarsMap.get("address");

        System.out.println("id" + id);
        System.out.println("name" + name);
        System.out.println("address" + address);
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    //optional parameter in url
    //http://localhost:8084/category1
    //or
    //http://localhost:8084/category1/1

    @GetMapping(value = {"/category1", "/category1/{id}"})
    public ResponseEntity<?> getCategoryByIdOptional(@PathVariable(value = "id", required = false) Integer id) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
        //System.out.println("optional id"+id);

        if (id != null) {
            System.out.println("optional id" + id);
        } else {
            System.out.println("id null");
        }

        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    //passing list in url

    //http://localhost:8084/categoryList/1,2,3,4,5

    @GetMapping(value = "/categoryList/{idList}")
    public ResponseEntity<?> getCategoryListparameters(@PathVariable List<Integer> idList) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
        System.out.println(idList);
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //http://localhost:8084/category2?id=1
    @GetMapping(value = "/category2")
    public ResponseEntity<?> getCategoryByIdQueryParam(@RequestParam("id") Integer id) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
        System.out.println("Query param id" + id);
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //http://localhost:8084/category3?id=10&&name=Bikash
    @GetMapping(value = "/category3")
    public ResponseEntity<?> getCategoryByIdAndNameQueryParam(@RequestParam("id") Integer id, @RequestParam String name) {
        // CategoryDto CategoryDto = categoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
        System.out.println("Query param id" + id);
        System.out.println("Query param name" + name);
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
//localhost:8084/category/category/1

    @PutMapping(value = "category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryDto categoryDto) {
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    //localhost:8084/category/1

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        responseDto.setStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(categoryDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


}