package com.ecommerce.firstspringproject.FirstProject.repositories;

import com.ecommerce.firstspringproject.FirstProject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReporsitory extends JpaRepository<Product, Integer> {
    Product save(Product product);
}
