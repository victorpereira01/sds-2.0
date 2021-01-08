package com.victorpereira.dsdeliver.controllers;

import com.victorpereira.dsdeliver.dto.OrderDTO;
import com.victorpereira.dsdeliver.dto.ProductDTO;
import com.victorpereira.dsdeliver.services.OrderService;
import com.victorpereira.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
    }
}
