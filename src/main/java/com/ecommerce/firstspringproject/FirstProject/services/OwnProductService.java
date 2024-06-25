package com.ecommerce.firstspringproject.FirstProject.services;

import com.ecommerce.firstspringproject.FirstProject.models.Category;
import com.ecommerce.firstspringproject.FirstProject.models.Product;

import java.util.List;

public class OwnProductService implements ProductService{
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProductWithoutResponseCode(int id) {
        return null;
    }

    @Override
    public Product getSingleProduct(int id) {
        return null;
    }
    @Override
    public Product CreateProduct(String title,
                                 String description,
                                 double price,
                                 String imageurl,
                                 String category) {
        return null;
    }
}

