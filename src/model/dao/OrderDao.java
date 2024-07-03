package model.dao;

import model.entity.Order;
import utils.DBException;

import java.util.List;

public interface OrderDao {
    int addNewOrder(Order order) throws DBException;
    List<Order> queryAllOrders() throws DBException;
    Order searchOrderById(Integer id) throws DBException;
}
