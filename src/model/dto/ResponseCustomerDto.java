package model.dto;

import java.sql.Date;

public record ResponseCustomerDto(
        Integer id,
        String name,
        String email,
        Date createdDate
) {
}
