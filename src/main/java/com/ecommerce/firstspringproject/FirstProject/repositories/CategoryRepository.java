package com.ecommerce.firstspringproject.FirstProject.repositories;

import com.ecommerce.firstspringproject.FirstProject.models.Category;
import com.ecommerce.firstspringproject.FirstProject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByTitle(String title);
    Category save(Category category);
}
