package com.victorpereira.dsdeliver.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.victorpereira.dsdeliver.entities.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Double price;

    private String description;

    private String imageUri;

    public ProductDTO(Product product) {
        super();
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUri = product.getImageUri();
    }
}
