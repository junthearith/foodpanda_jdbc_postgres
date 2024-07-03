package model.service;

import model.dto.CreateOrderDto;
import model.dto.ResponseOrderDto;
import utils.DBException;

import java.util.List;

public interface OrderService {
    int addNewOrder(CreateOrderDto createOrderDto) throws DBException;
    List<ResponseOrderDto> getAllOrders() throws DBException;
    int deleteOrderById(Integer id);
}
