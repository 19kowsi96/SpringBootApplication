package com.ecommerce.firstspringproject.FirstProject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String name;
    private String title;
    private double price;
    private String description;
    //private String category;
    private String imageurl;
    Category category;
}
