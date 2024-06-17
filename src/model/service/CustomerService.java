package model.service;

import exception.CustomerException;
import model.dao.CustomerDao;
import model.dto.CreateCustomerDto;
import model.dto.ResponseCustomerDto;
import utils.DBException;

import java.util.List;

public interface CustomerService {
    int addNewCustomer(CreateCustomerDto createCustomerDto) throws DBException;
    List<ResponseCustomerDto> getAllCustomers() throws DBException;
}
