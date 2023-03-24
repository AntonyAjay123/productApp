package com.example.productApp.service;

import com.example.productApp.dao.ProductRepository;
import com.example.productApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public ResponseEntity findById(int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
            return new ResponseEntity(product.get(), HttpStatus.OK);
        else return new ResponseEntity("no such product found",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity updateProduct(int id,Product toUpdate){
        Optional<Product> product = productRepository.findById(id);
        Product existingProduct=null;
        if(product.isPresent())
            existingProduct = product.get();
        else return new ResponseEntity("no such product found",HttpStatus.BAD_REQUEST);
        if(toUpdate.getDescription() !=null)
            existingProduct.setDescription(toUpdate.getDescription());
        if(toUpdate.getPrice()!=null)
            existingProduct.setPrice(toUpdate.getPrice());
        if(toUpdate.getTitle()!=null)
            existingProduct.setTitle(toUpdate.getTitle());
        productRepository.save(existingProduct);
        return new ResponseEntity("Product updated",HttpStatus.ACCEPTED);
    }

    public int saveProduct(Product product){
        productRepository.save(product);
        return product.getId();
    }

    public ResponseEntity deleteProduct(int id){
        productRepository.deleteById(id);
        return new ResponseEntity("Product deleted",HttpStatus.ACCEPTED);
    }
}
