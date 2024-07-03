package model.dto;

import model.entity.Customer;

import java.sql.Date;

public record ResponseOrderDto(
        Integer orderId,
        String orderName,
        String orderDescription,
        Customer customer,
        Date orderAt
) {
}
