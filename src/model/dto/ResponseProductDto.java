package model.dto;

import java.sql.Date;

public record ResponseProductDto(
        Integer id,
        String product_name,
        String product_code,
        Date expired_at,
        String product_description
) {
}
