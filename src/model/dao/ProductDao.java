package model.dao;

import model.entity.Product;
import utils.DBException;

import java.util.List;

public interface ProductDao {
    int addNewProduct(Product product) throws DBException;
    List<Product> queryAllProducts() throws DBException;
    int deleteProductById(Integer id);
    int updateProductById(Integer id);
    Product getProductById(Integer id);
}
