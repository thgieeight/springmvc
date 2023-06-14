package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RequestTypeExample3Controller {

//
//    List<InventoryDto> inventoryDtos = new ArrayList<>();
//    InventoryDto inventoryDto = new InventoryDto(1, "inventoryname", "inventory.png", "2022-01-02", 1);
//    ResponseDto responseDto = new ResponseDto();
//
//
//    @GetMapping(value = "/all-inventory")
//    public ResponseEntity<?> getAllInventory() {
//        inventoryDtos.add(inventoryDto);
//        inventoryDtos.add(inventoryDto);
//        inventoryDtos.add(inventoryDto);
//        responseDto.setStatus(true);
//        responseDto.setMessage("inventory list");
//        responseDto.setData(inventoryDtos);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/inventory/1
//    @GetMapping(value = "/inventory/{id}")
//    public ResponseEntity<?> getInventoryById(@PathVariable("id") Integer id) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);
//
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/inventory/1/Ram
//    @GetMapping(value = "/inventory/{id}/{name}")
//    public ResponseEntity<?> getInventoryByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(emp -> emp.getId() == id).collect(Collectors.toList()).get(0);
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/inventory/id/1/name/bikash
//    //path variable with name
//    @GetMapping(value = "/inventory/id/{id}/name/{name}")
//    public ResponseEntity<?> getInventoryByIdAndNameNew(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//    //using map to get value (use incase of mulitple parameteres)
////http://localhost:8084/inventory/1/Ram/Banepa
//    @GetMapping(value = "/inventory/{id}/{name}/{address}")
//    public ResponseEntity<?> getInventoryUsingMap(@PathVariable Map<String, String> pathVarsMap) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        String id = pathVarsMap.get("id");
//        String name = pathVarsMap.get("name");
//        String address = pathVarsMap.get("address");
//
//        System.out.println("id" + id);
//        System.out.println("name" + name);
//        System.out.println("address" + address);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //optional parameter in url
//    //http://localhost:8084/inventory1
//    //or
//    //http://localhost:8084/inventory1/1
//
//    @GetMapping(value = {"/inventory1", "/inventory1/{id}"})
//    public ResponseEntity<?> getInventoryByIdOptional(@PathVariable(value = "id", required = false) Integer id) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
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
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //passing list in url
//
//    //http://localhost:8084/inventoryList/1,2,3,4,5
//
//    @GetMapping(value = "/inventoryList/{idList}")
//    public ResponseEntity<?> getInventoryListparameters(@PathVariable List<Integer> idList) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println(idList);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/inventory2?id=1
//    @GetMapping(value = "/inventory2")
//    public ResponseEntity<?> getInventoryByIdQueryParam(@RequestParam("id") Integer id) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println("Query param id" + id);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//    //http://localhost:8084/inventory3?id=10&&name=Bikash
//    @GetMapping(value = "/inventory3")
//    public ResponseEntity<?> getInventoryByIdAndNameQueryParam(@RequestParam("id") Integer id, @RequestParam String name) {
//        // InventoryDto InventoryDto = inventoryDtos.stream().filter(cat -> cat.getId() == id).collect(Collectors.toList()).get(0);
//        System.out.println("Query param id" + id);
//        System.out.println("Query param name" + name);
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    @PostMapping
//    public ResponseEntity<?> addInventory(@RequestBody InventoryDto inventoryDto) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
////localhost:8084/inventory/inventory/1
//
//    @PutMapping(value = "inventory/{id}")
//    public ResponseEntity<?> updateInventory(@PathVariable("id") Integer id, @RequestBody InventoryDto inventoryDto) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//
//
//    //localhost:8084/inventory/1
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteInventory(@PathVariable("id") Integer id) {
//        responseDto.setStatus(true);
//        responseDto.setMessage("success");
//        responseDto.setData(inventoryDto);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
//    }
//

}
