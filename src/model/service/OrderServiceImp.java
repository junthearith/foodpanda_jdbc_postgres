package model.service;

import mapper.Mapper;
import model.dao.OrderDao;
import model.dao.OrderDaoImp;
import model.dto.CreateOrderDto;
import model.dto.ResponseOrderDto;
import model.entity.Order;
import utils.DBException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OrderServiceImp implements OrderService {

    private final OrderDao orderDao = new OrderDaoImp();
    private final Mapper mapper = new Mapper();
    @Override
    public int addNewOrder(CreateOrderDto createOrderDto) throws DBException {
        Order order = mapper.fromCreateOrderDtoToOrder(createOrderDto);
        order.setOrderedAt(Date.valueOf(LocalDate.now()));
        orderDao.addNewOrder(order);
        return 1;
    }

    @Override
    public List<ResponseOrderDto> getAllOrders() throws DBException {
        List<Order> orderLists = orderDao.queryAllOrders();
        if (orderLists.isEmpty()) {
            throw new DBException("Cannot get orders from database.");
        }
        return orderLists.stream()
                .map(mapper::fromOrderToResponseOrderDto)
                .toList();
    }

    @Override
    public int deleteOrderById(Integer id) {
        return 0;
    }
}
