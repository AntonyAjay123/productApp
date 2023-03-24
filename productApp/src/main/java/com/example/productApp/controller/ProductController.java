package com.example.productApp.controller;

import com.example.productApp.model.Product;
import com.example.productApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/productId")
    public ResponseEntity findById(@RequestParam int id){
        return productService.findById(id);
    }
    @PostMapping("/")
    public ResponseEntity saveProduct(@RequestBody Product product){
        int id = productService.saveProduct(product);
        return new ResponseEntity("Product saved with id "+id, HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity updateProduct(@RequestParam int id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
        return new ResponseEntity("Product deleted",HttpStatus.OK);
    }
}
