package model.dto;

public record CreateProductDto(
        String product_name,
        String product_code,
        String product_description
) {
}
