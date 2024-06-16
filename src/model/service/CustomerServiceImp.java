package model.service;

import mapper.Mapper;
import model.dao.CustomerDao;
import model.dao.CustomerDaoImp;
import model.dto.CreateCustomerDto;
import model.dto.ResponseCustomerDto;
import model.entity.Customer;
import utils.DBException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class CustomerServiceImp implements CustomerService{
    private final CustomerDao customerDao = new CustomerDaoImp();
    private final Mapper mapper = new Mapper();
    @Override
    public int addNewCustomer(CreateCustomerDto createCustomerDto) throws DBException {
        Customer customer = mapper.fromCustomerDtoToCustomer(createCustomerDto);
        customer.setCreatedDate(Date.valueOf(LocalDate.now()));
        customer.setIsDeleted(false);
        customerDao.addNewCustomer(customer);
        return 1;
    }

    @Override
    public List<ResponseCustomerDto> getAllCustomers() {
        return null;
    }
}
