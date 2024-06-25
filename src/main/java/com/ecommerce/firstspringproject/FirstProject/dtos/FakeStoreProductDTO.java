package com.ecommerce.firstspringproject.FirstProject.dtos;

import com.ecommerce.firstspringproject.FirstProject.models.Category;
import com.ecommerce.firstspringproject.FirstProject.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private String image;
    private String description;
    String category;
    private double price;

   /* one way
    public Product toProduct(FakeStoreProductDTO fakeStoreProductDTO)
    {
        Product pt = new Product();
        pt.setId(fakeStoreProductDTO.id);
        pt.setName(fakeStoreProductDTO.title);
        pt.setImageurl(fakeStoreProductDTO.image);
        pt.setDescription(fakeStoreProductDTO.description);
        pt.setPrice(fakeStoreProductDTO.price);

        Category ct = new Category();
        ct.setTitle(fakeStoreProductDTO.title);
        ct.setDescription(fakeStoreProductDTO.description);
        pt.setCategory(ct);
        return pt;
    }
    */

    //second way
   public Product toProduct()
   {
       Product pt = new Product();
       pt.setId(id);
       pt.setTitle(title);
       pt.setImageurl(image);
       pt.setDescription(description);
       pt.setPrice(price);

       Category ct = new Category();
       ct.setTitle(category);
       pt.setCategory(ct);
       return pt;
   }
}
