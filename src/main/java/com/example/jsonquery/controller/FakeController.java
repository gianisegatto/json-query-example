package com.example.jsonquery.controller;

import com.example.jsonquery.domain.Product;
import com.example.jsonquery.domain.Attribute;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FakeController {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> list() {

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i);
            product.setName("name " + i);
            product.setDescription("description " + i);

            List<Attribute> attributes = new ArrayList<>();

            for (int j = 0; j < 10; j++) {
                Attribute attribute = new Attribute();
                attribute.setId(j);
                attribute.setDescription("Attribute description " + j);
                attribute.setName("Attribute name " + j);

                attributes.add(attribute);
            }

            product.setAttributes(attributes);

            products.add(product);
        }

        return new ResponseEntity(products, HttpStatus.OK);
    }
}