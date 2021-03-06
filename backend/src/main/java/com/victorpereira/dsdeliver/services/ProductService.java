package com.victorpereira.dsdeliver.services;

import com.victorpereira.dsdeliver.dto.ProductDTO;
import com.victorpereira.dsdeliver.entities.Product;
import com.victorpereira.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAllByOrderByNameAsc();
        return products.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
    }
}
