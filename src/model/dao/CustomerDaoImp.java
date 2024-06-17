package model.dao;

import model.entity.Customer;
import utils.DBException;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImp implements CustomerDao {
    @Override
    public int addNewCustomer(Customer customer) throws DBException {
        String sql = """
                INSERT INTO "customer" (name, email, password, is_deleted, created_date)
                VALUES (?, ?, ?, ?, ?)
                """;
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setBoolean(4, customer.getIsDeleted());
            preparedStatement.setDate(5, customer.getCreatedDate());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Customer has been created successfully.");
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Customer> queryAllCustomers() throws DBException {
        String sql = """
                SELECT * FROM "customer"
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            List<Customer> customerList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerList.add(new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_deleted"),
                        resultSet.getDate("created_date")
                ));
            }
            return customerList;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
//        return new ArrayList<>();
    }

    @Override
    public int deleteCustomerById(Integer id) throws DBException {
        String sql = """
                DELETE FROM "customer" WHERE id = ?
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
//        return 0;
    }

    @Override
    public int updateCustomerById(Integer id) throws DBException {
        String sql = """
                UPDATE "customer"
                SET name = ?, email = ?
                WHERE id = ?
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            Customer customer = getCustomerById(id);
            if (customer != null) {
                return 0;
            }
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
//        return 0;
    }

    @Override
    public Customer getCustomerById(Integer id) throws DBException {
        String sql = """
                SELECT * FROM "customer" WHERE id = ?
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            Customer customer = new Customer();
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                customer.setIsDeleted(resultSet.getBoolean("is_deleted"));
                customer.setCreatedDate(resultSet.getDate("created_date"));
            }
            return customer;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
//        return new Customer();
    }
}
