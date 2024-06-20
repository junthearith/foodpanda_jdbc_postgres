package model.service;

import model.dto.CreateProductDto;
import model.dto.ResponseProductDto;
import utils.DBException;

import java.util.List;

public interface ProductService {
    int addNewProduct(CreateProductDto createProductDto) throws DBException;
    List<ResponseProductDto> getAllProducts() throws DBException;
    int deleteProductById(Integer id);
}
