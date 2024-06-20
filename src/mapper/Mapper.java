package mapper;

import model.dto.CreateCustomerDto;
import model.dto.CreateProductDto;
import model.dto.ResponseCustomerDto;
import model.dto.ResponseProductDto;
import model.entity.Customer;
import model.entity.Product;

public class Mapper {
    public Customer fromCustomerDtoToCustomer(CreateCustomerDto createCustomerDto) {
        if (createCustomerDto == null) {
            return null;
        }
        return new Customer(
                createCustomerDto.name(),
                createCustomerDto.email(),
                createCustomerDto.password()
        );
    }
    public ResponseCustomerDto fromCustomerToResponseCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new ResponseCustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getCreatedDate()
        );
    }
    public Product fromCreateProductDtoToProduct(CreateProductDto createProductDto) {
        if (createProductDto == null) {
            return null;
        }
        return new Product(
                createProductDto.product_name(),
                createProductDto.product_code(),
                createProductDto.product_description()
        );
    }
    public ResponseProductDto fromProductToResponseProductDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ResponseProductDto(
                product.getId(),
                product.getProductName(),
                product.getProductCode(),
                product.getExpiredDate(),
                product.getDescription()
        );
    }
}
