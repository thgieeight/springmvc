package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.SellsDto;
import com.inventory.invmgtsys.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RequestTypeExample4Controller {
//
//    List<SellsDto> sellsDtos = new ArrayList<>();
//    SellsDto sellsDto = new SellsDto(1, "sellsname", "sells.png", "2022-01-02", 1);
//    ResponseDto responseDto = new ResponseDto();
//
//
//    @GetMapping(value = "/all-sells")
//    public ResponseEntity<?> getAllSells() {
//        sellsDtos.add(sellsDto);
//        sellsDtos.add(sellsDto);
//        sellsDtos.add(sellsDto);
//        responseDto.setStatus(true);
//        responseDto.setMessage("sells list");
//        responseDto.setData(sellsDtos);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/sells/1
//    @GetMapping(value = "/sells/{id}")
//    public ResponseEntity<?> getSellsById(@PathVariable("id") Integer id) {
//        // SellDto SellDto = sellsDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);
//
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/sells/1/Ram
//    @GetMapping(value = "/sells/{id}/{name}")
//    public ResponseEntity<?> getSellsByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//        // SellDto SellDto = sellsDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/sells/id/1/name/bikash
//    //path variable with name
//    @GetMapping(value = "/sells/id/{id}/name/{name}")
//    public ResponseEntity<?> getSellsByIdAndNameNew(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//        // SellDto SellDto = sellsDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//    //using map to get value (use incase of mulitple parameteres)
////http://localhost:8084/sells/1/Ram/Banepa
//    @GetMapping(value = "/sells/{id}/{name}/{address}")
//    public ResponseEntity<?> getSellsUsingMap(@PathVariable Map<String, String> pathVarsMap) {
//        // SellDto SellDto = sellsDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        String id = pathVarsMap.get("id");
//        String name = pathVarsMap.get("name");
//        String address = pathVarsMap.get("address");
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        System.out.println("address" + address);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //optional parameter in url
//    //http://localhost:8084/sells1
//    //or
//    //http://localhost:8084/sells1/1
//
//    @GetMapping(value = {"/sells1", "/sells1/{id}"})
//    public ResponseEntity<?> getSellsByIdOptional(@PathVariable(value = "id", required = false) Integer id) {
//        // SellDto SellDto = sellsDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
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
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //passing list in url
//
//    //http://localhost:8084/sellsList/1,2,3,4,5
//
//    @GetMapping(value = "/sellsList/{idList}")
//    public ResponseEntity<?> getSellsListparameters(@PathVariable List<Integer> idList) {
//        // SellDto SellDto = sellsDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println(idList);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/sells2?id=1
//    @GetMapping(value = "/sells2")
//    public ResponseEntity<?> getSellsByIdQueryParam(@RequestParam("id") Integer id) {
//        // SellDto SellDto = sellsDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println("Query param id" + id);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/sells3?id=10&&name=Bikash
//    @GetMapping(value = "/sells3")
//    public ResponseEntity<?> getSellsByIdAndNameQueryParam(@RequestParam("id") Integer id, @RequestParam String name) {
//        // SellDto SellDto = sellsDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println("Query param id" + id);
//        System.out.println("Query param name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    @PostMapping
//    public ResponseEntity<?> addSells(@RequestBody SellsDto sellsDto) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
////localhost:8084/sells/sells/1
//
//    @PutMapping(value = "sells/{id}")
//    public ResponseEntity<?> updateSells(@PathVariable("id") Integer id, @RequestBody SellsDto sellsDto) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //localhost:8084/sells/1
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteSells(@PathVariable("id") Integer id) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(sellsDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//

}
