package model.dao;

import model.entity.Customer;
import model.entity.Order;
import utils.DBException;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImp implements OrderDao {
    @Override
    public int addNewOrder(Order order) throws DBException {
        String sql = """
                INSERT INTO "order" (order_name, order_description, cus_id, ordered_at)
                VALUES (?, ?, ?, ?)
                """;
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, order.getOrderName());
            preparedStatement.setString(2, order.getOrderDescription());
            preparedStatement.setInt(3, order.getCustomer().getId());
            preparedStatement.setDate(4, order.getOrderedAt());
            int rowAffected = preparedStatement.executeUpdate();
            String message = rowAffected > 0 ? "Add successfully." : "Insert failed!";
            System.out.println(message);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Order> queryAllOrders() throws DBException{
        String sql = """
                SELECT * FROM "order"
                INNER JOIN customer c on "order".cus_id = c.id
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            List<Order> orderList = new ArrayList<>();
            while (rs.next()) {
                orderList.add(new Order(
                        rs.getInt("id"),
                        rs.getString("order_name"),
                        rs.getString("order_description"),
                        new Customer(
                                rs.getInt("cus_id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getBoolean("is_deleted"),
                                rs.getDate("created_date")
                        ),
                        rs.getDate("ordered_at")
                ));
            }
            return orderList;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
//        return new ArrayList<>();
    }

    @Override
    public Order searchOrderById(Integer id) throws DBException{
        String sql = """
                SELECT * FROM "order"
                WHERE id = ?
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getString("order_name"),
                        resultSet.getString("order_description"),
                        new Customer(
                                resultSet.getInt("cus_id")
                        ),
                        resultSet.getDate("ordered_at")
                );
            }
            return order;
        } catch (SQLException e) {
            throw new DBException(e);
        }
//        return null;
    }
}
