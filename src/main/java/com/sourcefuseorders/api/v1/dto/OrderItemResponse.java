package com.sourcefuseorders.api.v1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponse {

    private String name;

    private int quantity;

    private double price;
}
