package model.dto;

import model.entity.Customer;

public record CreateOrderDto(
        String order_name,
        String order_description,
        Customer customer
) {
}
