package com.ecommerce.firstspringproject.FirstProject.services;

import com.ecommerce.firstspringproject.FirstProject.models.Category;
import com.ecommerce.firstspringproject.FirstProject.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(int id);
    List<Product> getAllProducts();
    Product getSingleProductWithoutResponseCode(int id);
    Product CreateProduct(String title,
                          String description,
                          double price,
                          String imageurl,
                          String category);
}
