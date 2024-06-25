package com.ecommerce.firstspringproject.FirstProject.controllers;

import com.ecommerce.firstspringproject.FirstProject.dtos.FakeStoreProductDTO;
import com.ecommerce.firstspringproject.FirstProject.dtos.RequestBodyProductdto;
import com.ecommerce.firstspringproject.FirstProject.models.Product;
import com.ecommerce.firstspringproject.FirstProject.services.FakeStoreProductService;
import com.ecommerce.firstspringproject.FirstProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
     /* use case for create ProductService as interface and accessed by its child ie.just implements
    ProductService ps = new FakeStoreProductService();
    ProductService ps2 = new OwnProductService();
    */
   /*
    one way to do crete direcly --- > ProductService ps = new FakeStoreProductService();
       Second way (optimal way)---> ProductService ps; and
       then create parameterized constructor and call it.
    */
    ProductService ps;
    /*public ProductController(@Qualifier("fakestore") ProductService ps2)
    {
        this.ps = ps2;
    }
    */
    @Autowired
    public ProductController(@Qualifier("selfproductservice") ProductService ps2)
    {
        this.ps = ps2;
    }

    //qualifier is used to identify the dependency ex:FakeStoreProductService
    /*POST/products --- >End point to create new product
    Accept request body(JSON)
    we can careate like this if we donot have seperate RequestBodyProductdto class.
    public void CreateProduct(@RequestBody
                                String title,
                                String descritpion,
                                double price,
                                String image)
    {
    }
     */
    @PostMapping("/products")
    public Product CreateProduct(@RequestBody RequestBodyProductdto request)
    {
        /*
        "id":
        "name":
        "price":
        "description":
        "category":
        "title":
         */
        return null;
        /*ps.CreateProduct(request.getTitle(),
                request.getDescription(),
                request.getPrice(),
                request.getImage(),
                request.getCategory());
          */
    }
    /*@GetMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable ("id") int id)
    {
        Product pr = ps.getSingleProduct(id);
        if(id==0)
        {
            throw new RuntimeException();//throws an error
        }
        return new ResponseEntity<>(pr, HttpStatus.CONFLICT);//here we are write our own status code
    }
*/
    //how to handle the exceptions
    /*@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(Exception ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
    */
    //get single product
   @GetMapping("/products/SingleProduct/{id}")
    public Product getSingleProductWithoutResponseCode(@PathVariable ("id") int id)
    {
        return ps.getSingleProductWithoutResponseCode(id);
    }

   //getAll proudcts
    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return ps.getAllProducts();
    }

    //update the product
    @PutMapping("/products")
    public void updateProduct()
    {

    }
}



/*
Every api call at the end of the day is a method call inside a controller
 */