package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.converter.CategoryConverter;
import com.inventory.invmgtsys.converter.ProductConverter;
import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.InventoryDto;
import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.service.CategoryService;
import com.inventory.invmgtsys.service.InventoryService;
import com.inventory.invmgtsys.service.ProductService;
import com.inventory.invmgtsys.utils.CommonUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductConverter productConverter;
    @Autowired
    CategoryConverter categoryConverter;
    @GetMapping("/inventory")
    public String getInventory(Model model) {
        List<InventoryDto> inventoryDtoList = inventoryService.getInventoryList();
        model.addAttribute("inventoryList", inventoryDtoList);
        return "inventory";
    }
    @PostMapping("/add-inventory")

    public String addNewInventory(InventoryDto inventoryDto, @RequestParam("inventoryImage") MultipartFile inventoryImage) throws IOException {

        try {


            String imageUploadDirectory = "D:\\invmgtsys\\src\\main\\uploads";

            if (!inventoryImage.isEmpty()) {



                String filename = CommonUtilities.generateUniqueFileName();

                Path fileNameAndPath = Paths.get(imageUploadDirectory, filename + ".png");

                //get file size in mb

                System.out.println("file size:" + inventoryImage.getSize());

                //file.getContentType()  check file type png jpeg

                System.out.println("file type:" + inventoryImage.getContentType());



                try {

                    Files.write(fileNameAndPath, inventoryImage.getBytes());


                } catch (IOException e) {



                    e.printStackTrace();

                }

                inventoryDto.setImage(filename+".png");

            }

            inventoryDto.setAddedDate(CommonUtilities.getCurrentDateTime());

            ProductDto productDto=productService.getProductById(inventoryDto.getProductId());
            inventoryDto.setProduct(productConverter.productDtoToProductEntity(productDto));

//            inventoryDto.setQuantity(CommonUtilities.getQunatity);

            inventoryService.addorUpdateInventory(inventoryDto);

            return "redirect:/inventory";



        } catch (Exception e) {

            System.out.println(e);

        }

        return "redirect:/inventory";

    }
    @PostMapping("/update-inventory")
    public String updateInventory(@ModelAttribute("inventory") InventoryDto inventoryDto, @RequestParam("inventoryImage") MultipartFile inventoryImage) throws IOException {
        try {
            String imageUploadDirectory = "D:\\invmgtsys\\src\\main\\uploads";
            System.out.println(inventoryDto.getInventoryName());
            if (!inventoryImage.isEmpty()) {
                String filename = CommonUtilities.generateUniqueFileName();
                Path fileNameAndPath = Paths.get(imageUploadDirectory, filename + ".png");
                //get file size in mb
                System.out.println("file size:" + inventoryImage.getSize());
                //file.getContentType()  check file type png jpeg
                System.out.println("file type:" + inventoryImage.getContentType());

                try {
                    Files.write(fileNameAndPath, inventoryImage.getBytes());

                } catch (IOException e) {

                    e.printStackTrace();
                }
                inventoryDto.setImage(filename+".png");

            }else{
                InventoryDto inventoryDto1=inventoryService.getInventoryById(inventoryDto.getInventoryId());
                inventoryDto.setImage(inventoryDto1.getImage());


            }
            inventoryDto.setAddedDate(CommonUtilities.getCurrentDateTime());

            ProductDto productDto=productService.getProductById(inventoryDto.getProductId());
            inventoryDto.setProduct(productConverter.productDtoToProductEntity(productDto));

            inventoryService.addorUpdateInventory(inventoryDto);

            return "redirect:/inventory";

        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/inventory";

    }

    @PostMapping("/delete-inventory")
    public String deleteInventory(@RequestParam("inventoryId") Integer inventoryId){
        System.out.println("delete controller inventoryId"+inventoryId);
        InventoryDto inventoryDto=inventoryService.getInventoryById(inventoryId);
        inventoryDto.setStatus(0);
        inventoryService.addorUpdateInventory(inventoryDto);
        return "redirect:/inventory";
    }
}