package com.edex.ecommerce.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.ecommerce.dto.request.ProductRequestDto;
import com.edex.ecommerce.model.Product;
import com.edex.ecommerce.repo.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/insert")
    public String insert(@ModelAttribute ProductRequestDto dto) throws Exception{
        String uploadLocation = "/home/kernelogy/learn/spring/ecommerce/src/main/resources/uploads/";
        //Write the incoming file to the above location
        Path path = Paths.get(uploadLocation + new Date().getTime() + dto.getImage().getOriginalFilename());
        Files.write(path, dto.getImage().getBytes());
        //Create a model to write to the database
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImage(path.getFileName().toString());
        //Write the model to the database
        productRepo.saveAndFlush(product);
        return "Product Created Successfully";
    }
}
