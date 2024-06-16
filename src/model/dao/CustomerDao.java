package model.dao;

import model.entity.Customer;
import utils.DBException;

import java.util.List;

public interface CustomerDao {
    int addNewCustomer(Customer customer) throws DBException;
    List<Customer> queryAllCustomers() throws DBException;
    int deleteCustomerById(Integer id);
    int updateCustomerById(Integer id);
    Customer getCustomerById(Integer id);
}
