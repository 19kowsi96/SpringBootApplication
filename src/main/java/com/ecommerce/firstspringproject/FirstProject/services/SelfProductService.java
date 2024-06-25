//purpose of this class ---> create our own product

package com.ecommerce.firstspringproject.FirstProject.services;

import com.ecommerce.firstspringproject.FirstProject.models.Category;
import com.ecommerce.firstspringproject.FirstProject.models.Product;
import com.ecommerce.firstspringproject.FirstProject.repositories.CategoryRepository;
import com.ecommerce.firstspringproject.FirstProject.repositories.ProductReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfproductservice")
public class SelfProductService implements ProductService{

    private ProductReporsitory productReporsitory;
    private CategoryRepository categoryRepository;
    @Autowired
    public SelfProductService(ProductReporsitory productReporsitory,CategoryRepository categoryRepository)
    {
        this.productReporsitory = productReporsitory;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product CreateProduct(String title, String description, double price, String imageurl, String category) {
        Product pt = new Product();
        pt.setTitle(title);
        pt.setDescription(description);
        pt.setPrice(price);
        pt.setImageurl(imageurl);
        //Category categoryFromDatabase = categoryRepository.findByTitle(category);
//        pt.setCategory(category);
        Category categoryFromDatabase = categoryRepository.findByTitle(category);

        if(categoryFromDatabase == null){
            Category category1 = new Category();
            category1.setTitle(category);
            //categoryRepository.save(category1); //persist as cascade type
            categoryFromDatabase = category1;
        }

        pt.setCategory(categoryFromDatabase); //persist as cascade type

        Product savedProduct = productReporsitory.save(pt);
        return savedProduct;
    }

    @Override
    public Product getSingleProduct(int id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProductWithoutResponseCode(int id) {
        return null;
    }

}
