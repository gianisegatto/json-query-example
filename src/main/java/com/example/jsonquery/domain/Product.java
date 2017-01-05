package com.example.jsonquery.domain;

import java.util.List;

/**
 * Created by gianisegatto on 04/01/2017.
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private List<Attribute> attributes;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(final List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
