package com.ecommerce.firstspringproject.FirstProject.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestBodyProductdto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String Category;
}


/*
Create different DTO for each request so that in future if we need to add additional param it could be easy.
 */