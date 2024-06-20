package model.dao;

import model.entity.Product;
import utils.DBException;
import utils.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    @Override
    public int addNewProduct(Product product) throws DBException {
        String sql = """
                INSERT INTO "product" (product_name, product_code, is_deleted, imported_at, expired_at, product_description)
                VALUES (?, ?, ?, ?, ?, ?);
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductCode());
            preparedStatement.setBoolean(3, product.getIsDeleted());
            preparedStatement.setDate(4, product.getImportedDate());
            preparedStatement.setDate(5, product.getExpiredDate());
            preparedStatement.setString(6, product.getDescription());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
//        return 0;
    }

    @Override
    public List<Product> queryAllProducts() throws DBException {
        String sql = """
                SELECT * FROM "product"
                """;
        try(
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            List<Product> productList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("product_code"),
                        resultSet.getBoolean("is_deleted"),
                        resultSet.getDate("imported_at"),
                        resultSet.getDate("expired_at"),
                        resultSet.getString("product_description")
                ));
            }
            return productList;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
//        return new ArrayList<>();
    }

    @Override
    public int deleteProductById(Integer id) {
        return 0;
    }

    @Override
    public int updateProductById(Integer id) {
        return 0;
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }
}
