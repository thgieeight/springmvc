package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.service.CategoryService;
import com.inventory.invmgtsys.utils.CommonUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category")
    public String getCategory(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.getCategoryList();
        model.addAttribute("categoryList", categoryDtoList);
        return "category";
    }
    /*   @GetMapping("/category")
       public String getCategory(Model model) {
           List<CategoryDto> categoryDtoList=categoryService.getCategoryList();
           model.addAttribute("categoryList",categoryDtoList);
           model.addAttribute("categoryList",categoryDtoList);
           return "category";
       }*/
   /* @GetMapping("/cat")
    public List<CategoryDto>getCategory(){
        List<CategoryDto> categoryDtoList=categoryService.getCategoryList();
        return categoryDtoList;
    }
    @GetMapping("/save-cat")
    public String saveCat(){
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setCategoryName("Computer");
        categoryDto.setImage("test.png");
        categoryDto.setAddedDate("2022-10-20");
        categoryService.addorUpdateCategory(categoryDto);
        return "category added";
    }*/

    /*@GetMapping("/category")
    public String getCategory(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.getCategoryList();
        model.addAttribute("categoryList", categoryDtoList);
        return "category";
    }*/

    @PostMapping("/add-category")

    public String addNewCategory(@ModelAttribute("category") CategoryDto categoryDto, @RequestParam("categoryImage") MultipartFile categoryImage) throws IOException {

        try {


            String imageUploadDirectory = "D:\\invmgtsys\\src\\main\\uploads";

            if (!categoryImage.isEmpty()) {



                String filename = CommonUtilities.generateUniqueFileName();

                Path fileNameAndPath = Paths.get(imageUploadDirectory, filename + ".png");

                //get file size in mb

                System.out.println("file size:" + categoryImage.getSize());

                //file.getContentType()  check file type png jpeg

                System.out.println("file type:" + categoryImage.getContentType());



                try {

                    Files.write(fileNameAndPath, categoryImage.getBytes());



                } catch (IOException e) {



                    e.printStackTrace();

                }

                categoryDto.setImage(filename+".png");

            }

            categoryDto.setAddedDate(CommonUtilities.getCurrentDateTime());

            categoryService.addorUpdateCategory(categoryDto);

            return "redirect:/category";



        } catch (Exception e) {

            System.out.println(e);

        }

        return "redirect:/category";

    }
    @PostMapping("/update-category")
    public String updateCategory(@ModelAttribute("category") CategoryDto categoryDto, @RequestParam("categoryImage") MultipartFile categoryImage) throws IOException {
        try {
            String imageUploadDirectory = "D:\\invmgtsys\\src\\main\\uploads";
            System.out.println(categoryDto.getCategoryName());
            if (!categoryImage.isEmpty()) {
                String filename = CommonUtilities.generateUniqueFileName();
                Path fileNameAndPath = Paths.get(imageUploadDirectory, filename + ".png");
                //get file size in mb
                System.out.println("file size:" + categoryImage.getSize());
                //file.getContentType()  check file type png jpeg
                System.out.println("file type:" + categoryImage.getContentType());

                try {
                    Files.write(fileNameAndPath, categoryImage.getBytes());

                } catch (IOException e) {

                    e.printStackTrace();
                }
                categoryDto.setImage(filename+".png");

            }else{
                CategoryDto categoryDto1=categoryService.getCategoryById(categoryDto.getCategoryId());
                categoryDto.setImage(categoryDto1.getImage());


            }
            categoryDto.setAddedDate(CommonUtilities.getCurrentDateTime());
            categoryService.addorUpdateCategory(categoryDto);

            return "redirect:/category";

        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/category";

    }

    @PostMapping("/delete-category")
    public String deleteCategory(@RequestParam("categoryId") Integer categoryId){
        System.out.println("delete controller categoryId"+categoryId);
        CategoryDto categoryDto=categoryService.getCategoryById(categoryId);
        categoryDto.setStatus(0);
        categoryService.addorUpdateCategory(categoryDto);
        return "redirect:/category";
    }

}