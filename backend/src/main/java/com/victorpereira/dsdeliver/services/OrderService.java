package com.victorpereira.dsdeliver.services;

import com.victorpereira.dsdeliver.dto.OrderDTO;
import com.victorpereira.dsdeliver.dto.ProductDTO;
import com.victorpereira.dsdeliver.entities.Order;
import com.victorpereira.dsdeliver.entities.Product;
import com.victorpereira.dsdeliver.repositories.OrderRepository;
import com.victorpereira.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> products = orderRepository.findOrdersWithProducts();
        return products.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
    }
}
