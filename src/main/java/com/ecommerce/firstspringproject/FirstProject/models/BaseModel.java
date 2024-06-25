package com.ecommerce.firstspringproject.FirstProject.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    private int id;
    private Data date;
    private Data lastUpdated;
    private boolean softDelete;
}

/*
tell the spring which url
username
password
 */
