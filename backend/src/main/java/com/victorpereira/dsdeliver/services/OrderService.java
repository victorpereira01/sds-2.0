package com.victorpereira.dsdeliver.services;

import com.victorpereira.dsdeliver.dto.OrderDTO;
import com.victorpereira.dsdeliver.dto.ProductDTO;
import com.victorpereira.dsdeliver.entities.Order;
import com.victorpereira.dsdeliver.entities.Product;
import com.victorpereira.dsdeliver.enums.OrderStatus;
import com.victorpereira.dsdeliver.repositories.OrderRepository;
import com.victorpereira.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> products = orderRepository.findOrdersWithProducts();
        return products.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDto) {
        Order order = new Order(null, orderDto.getAddress(), orderDto.getLatitude(),
                orderDto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : orderDto.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        return new OrderDTO(orderRepository.save(order));
    }
}
