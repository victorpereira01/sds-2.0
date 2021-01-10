package com.victorpereira.dsdeliver.dto;

import com.victorpereira.dsdeliver.entities.Order;
import com.victorpereira.dsdeliver.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String address;

    private Double latitude;

    private Double longitude;

    private Instant moment;

    private OrderStatus status;

    private Double total;

    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO(Long id, String address, Double latitude, Double longitude,
                    Instant moment, OrderStatus status, Double total) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
        this.total = total;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.address = order.getAddress();
        this.latitude = order.getLatitude();
        this.longitude = order.getLongitude();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.total = order.getTotal();
        this.products = order.getProducts().stream()
                .map(o -> new ProductDTO(o)).collect(Collectors.toList());
    }
}
