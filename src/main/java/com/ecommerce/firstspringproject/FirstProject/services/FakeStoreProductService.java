package com.ecommerce.firstspringproject.FirstProject.services;

import com.ecommerce.firstspringproject.FirstProject.dtos.FakeStoreProductDTO;
import com.ecommerce.firstspringproject.FirstProject.models.Category;
import com.ecommerce.firstspringproject.FirstProject.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service("fakestore")
public class FakeStoreProductService implements ProductService{
    /*
    one way is create constructor and pass through it.
    ex: RestTemplate rs = new RestTemplate();(it depends)
    other way is injecting the object at once its enough.(Dependency Injection).
    Asks the spring to take care of it.
     */
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreRespose = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        /*
         List<FakeStoreProductDTO> fakeStoreRespose = restTemplate.getForObject("https://fakestoreapi.com/products",
                List<FakeStoreProductDTO>.class); --->create run time error
         */
        /*
         ResponeEntity<FakeStoreProductDTO> fakeStoreRespose = restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

               ResponeEntity<FakeStoreProductDTO>  --- > get status - gives error codes, getBody - give object of fakestore API
         */
        /* first way
        ResponeEntity<FakeStoreProductDTO> fakeStoreRespose = restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        ArrayList<Product> ar = new ArrayList<>();
        for(FakeStoreProductDTO product:fakeStoreRespose)
        {
             ar.add(product.toProduct());
        }
        return ar;
         */
        ArrayList<Product> ar = new ArrayList<>();
        for(FakeStoreProductDTO product:fakeStoreRespose)
        {
            ar.add(product.toProduct());
        }
        return ar;
    }


    @Override
    public Product getSingleProduct(int id) {
        if(id == 0)
        {
            throw new IllegalArgumentException("Invalid Product Id");
        }
        //make a external fakestore here
        /*one way get object itself
        FakeStoreProductDTO fakeStoreRespose = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
          FakeStoreProductDTO.class);//this line convert fake store JSON response into dto class object.
        */
        //here we have multiple data with status code
        ResponseEntity<FakeStoreProductDTO> fakeStoreRespose = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);//this line convert fake store JSON response into dto class object.
        //here we can get status code
        return fakeStoreRespose.getBody().toProduct();
    }

    @Override
    public Product getSingleProductWithoutResponseCode(int id) {
        //make a external fakestore here
        FakeStoreProductDTO fakeStoreRespose = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
          FakeStoreProductDTO.class);//this line convert fake store JSON response into dto class object.
         return fakeStoreRespose.toProduct();
    }

    @Override
    public Product CreateProduct(String title,
                                 String description,
                                 double price,
                                 String imageurl,
                                 String category) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setImage(imageurl);
        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDTO,FakeStoreProductDTO.class);
        return fakeStoreProductDTO1.toProduct();
    }
}
/*
Rest Template used for allowing the service sent the http requets to external API.

 */