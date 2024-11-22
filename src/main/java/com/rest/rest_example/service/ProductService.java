package com.rest.rest_example.service;

import com.rest.rest_example.model.Product;
import java.util.*;
public interface ProductService {
    List<Product> getAllProduct();
    Product getAllProduct(int id, String name);
    List<Product> addProduct(Product product);
    Product updatePrice(int id, int price);
}
