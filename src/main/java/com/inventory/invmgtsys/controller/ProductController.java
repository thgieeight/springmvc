package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.converter.CategoryConverter;
import com.inventory.invmgtsys.dto.CategoryDto;
import com.inventory.invmgtsys.dto.ProductDto;
import com.inventory.invmgtsys.service.CategoryService;
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
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryConverter categoryConverter;
    @GetMapping("/product")
    public String getProduct(Model model) {
        List<ProductDto> productDtoList = productService.getProductList();
        model.addAttribute("productList", productDtoList);
        return "product";
    }
    @PostMapping("/add-product")

    public String addNewProduct(@ModelAttribute("product") ProductDto productDto, @RequestParam("productImage") MultipartFile productImage) throws IOException {

        try {


            String imageUploadDirectory = "D:\\invmgtsys\\src\\main\\uploads";

            if (!productImage.isEmpty()) {



                String filename = CommonUtilities.generateUniqueFileName();

                Path fileNameAndPath = Paths.get(imageUploadDirectory, filename + ".png");

                //get file size in mb

                System.out.println("file size:" + productImage.getSize());

                //file.getContentType()  check file type png jpeg

                System.out.println("file type:" + productImage.getContentType());



                try {

                    Files.write(fileNameAndPath, productImage.getBytes());



                } catch (IOException e) {



                    e.printStackTrace();

                }

                productDto.setImage(filename+".png");

            }

            productDto.setAddedDate(CommonUtilities.getCurrentDateTime());

            CategoryDto categoryDto=categoryService.getCategoryById(productDto.getCategoryId());
            productDto.setCategory(categoryConverter.categoryDtoToCategoryEntity(categoryDto));

            productService.addorUpdateProduct(productDto);

            return "redirect:/product";



        } catch (Exception e) {

            System.out.println(e);

        }

        return "redirect:/product";

    }
    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute("product") ProductDto productDto, @RequestParam("productImage") MultipartFile productImage) throws IOException {
        try {
            String imageUploadDirectory = "D:\\invmgtsys\\src\\main\\uploads";
            System.out.println(productDto.getProductName());
            if (!productImage.isEmpty()) {
                String filename = CommonUtilities.generateUniqueFileName();
                Path fileNameAndPath = Paths.get(imageUploadDirectory, filename + ".png");
                //get file size in mb
                System.out.println("file size:" + productImage.getSize());
                //file.getContentType()  check file type png jpeg
                System.out.println("file type:" + productImage.getContentType());

                try {
                    Files.write(fileNameAndPath, productImage.getBytes());

                } catch (IOException e) {

                    e.printStackTrace();
                }
                productDto.setImage(filename+".png");

            }else{
                ProductDto productDto1=productService.getProductById(productDto.getProductId());
                productDto.setImage(productDto1.getImage());


            }
            CategoryDto categoryDto=categoryService.getCategoryById(productDto.getCategoryId());
            productDto.setCategory(categoryConverter.categoryDtoToCategoryEntity(categoryDto));
            productDto.setAddedDate(CommonUtilities.getCurrentDateTime());
            productService.addorUpdateProduct(productDto);

            return "redirect:/product";

        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/product";

    }

    @PostMapping("/delete-product")
    public String deleteProduct(@RequestParam("productId") Integer productId){
        System.out.println("delete controller productId"+productId);
        ProductDto productDto=productService.getProductById(productId);
        productDto.setStatus(0);
        productService.addorUpdateProduct(productDto);
        return "redirect:/product";
    }
}
