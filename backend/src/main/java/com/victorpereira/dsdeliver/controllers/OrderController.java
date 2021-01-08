package com.victorpereira.dsdeliver.controllers;

import com.victorpereira.dsdeliver.dto.OrderDTO;
import com.victorpereira.dsdeliver.dto.ProductDTO;
import com.victorpereira.dsdeliver.services.OrderService;
import com.victorpereira.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO orderDto) {
        orderDto = orderService.insert(orderDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(orderDto.getId()).toUri();
        return ResponseEntity.created(uri).body(orderDto);
    }
}
