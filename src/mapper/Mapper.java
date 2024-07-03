package mapper;

import model.dto.*;
import model.entity.Customer;
import model.entity.Order;
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
    public Order fromCreateOrderDtoToOrder(CreateOrderDto createOrderDto) {
        if (createOrderDto == null) {
            return null;
        }
        return new Order(
                createOrderDto.order_name(),
                createOrderDto.order_description(),
                createOrderDto.customer()
        );
    }
    public ResponseOrderDto fromOrderToResponseOrderDto(Order order) {
        if (order == null) {
            return null;
        }
        return new ResponseOrderDto(
                order.getId(),
                order.getOrderName(),
                order.getOrderDescription(),
                order.getCustomer(),
                order.getOrderedAt()
        );
    }
}
