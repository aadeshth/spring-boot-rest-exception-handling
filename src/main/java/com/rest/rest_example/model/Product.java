package com.rest.rest_example.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
 private int id;
 private String name;
 private int price;
}
