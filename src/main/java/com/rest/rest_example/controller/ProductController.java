package com.rest.rest_example.controller;

import com.rest.rest_example.model.Product;
import com.rest.rest_example.model.ProductResponse;
import com.rest.rest_example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("api/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Object> getProductList()
    {
        return ResponseEntity.ok(productService.getAllProduct());
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") int id, @RequestParam(value = "name",required = false) String name)
    {
        return ResponseEntity.ok(ProductResponse.builder().data(productService.getAllProduct(id, name)).status(HttpStatus.OK.name()).message("Data Fetched!").build());
    }
    @PatchMapping("{id}/{price}")
    public ResponseEntity<Object> addProduct(@PathVariable("id") int id,@PathVariable("price") int price){
        return ResponseEntity.ok(ProductResponse.builder().data(productService.updatePrice(id, price)).status(HttpStatus.OK.name()).message("Data modified!").build());
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(ProductResponse.builder().data(productService.addProduct(product)).status(HttpStatus.OK.name()).message("Data created!").build());
    }



}
