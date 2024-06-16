package mapper;

import model.dto.CreateCustomerDto;
import model.dto.ResponseCustomerDto;
import model.entity.Customer;

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
}
