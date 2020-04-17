package com.example.eureka_client.service;

import com.example.eureka_client.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();
    Product findById(int id);
}
