package com.ecommerce.firstspringproject.FirstProject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAPICall {
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    //name came from request
    @RequestMapping("/hei/{nameFromRequest}")
    public String sayHelloToSomeone(@PathVariable("nameFromRequest") String SomeOneName)
    {
        return "hei "+SomeOneName;
    }

}
/*
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/productservicespringboot
spring.datasource.username=productseviceuser
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true
 */
