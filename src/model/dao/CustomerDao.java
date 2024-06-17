package model.dao;

import model.entity.Customer;
import utils.DBException;

import java.util.List;

public interface CustomerDao {
    int addNewCustomer(Customer customer) throws DBException;
    List<Customer> queryAllCustomers() throws DBException;
    int deleteCustomerById(Integer id) throws DBException;
    int updateCustomerById(Integer id) throws DBException;
    Customer getCustomerById(Integer id) throws DBException;
}
