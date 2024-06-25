package com.ecommerce.firstspringproject.FirstProject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
/*
first object is injectable is Rest Template
 */
    @Bean
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate();
    }
}


/*
Here store all beans ie. Rest Template class
 */