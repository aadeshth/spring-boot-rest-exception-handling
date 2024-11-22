package com.rest.rest_example.service;

import com.rest.rest_example.exception.ProductNotFoundException;
import com.rest.rest_example.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {
    private static final ArrayList<Product> products = new ArrayList<>();
   static {
       products.add(Product.builder().id(1).name("Mouse").price(500).build());
       products.add(Product.builder().id(2).name("Pen").price(100).build());
       products.add(Product.builder().id(3).name("Mouse").price(1100).build());
    }
    @Override
    public List<Product> getAllProduct(){
        return products;
    }
    @Override
    public Product getAllProduct(int id, String name) {
        if (name == null) {
            Optional<Product> productOptional = products.stream().filter(product -> product.getId() == id).findFirst();
            if (productOptional.isPresent())
                return productOptional.get();
        } else {
            Optional<Product> productOptional = products.stream().filter(product -> product.getId() == id && product.getName().equals(name)).findFirst();
            if (productOptional.isPresent())
                return productOptional.get();
        }
        return null;
    }

    @Override
    public List<Product> addProduct(Product product) {
       products.add(product);
        return products;
    }

    @Override
    public Product updatePrice(int id, int price) {
        Optional<Product> productOptional = products.stream().filter(p -> p.getId() == id).findFirst();
        Product product;
        if (productOptional.isPresent()){
            product = productOptional.get();
            product.setPrice(price);
        } else
            throw new ProductNotFoundException("Record Not Found!");
         return product;
    }
}
