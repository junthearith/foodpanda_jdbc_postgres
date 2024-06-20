package model.service;

import mapper.Mapper;
import model.dao.ProductDao;
import model.dao.ProductDaoImp;
import model.dto.CreateProductDto;
import model.dto.ResponseProductDto;
import model.entity.Product;
import utils.DBException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ProductServiceImp implements ProductService {
    private final ProductDao productDao = new ProductDaoImp();
    private final Mapper mapper = new Mapper();
    @Override
    public int addNewProduct(CreateProductDto createProductDto) throws DBException {
        Product product = mapper.fromCreateProductDtoToProduct(createProductDto);
        product.setIsDeleted(false);
        product.setImportedDate(Date.valueOf(LocalDate.now()));
        product.setExpiredDate(Date.valueOf(LocalDate.now().plusMonths(3)));
        productDao.addNewProduct(product);
        return 1;
    }

    @Override
    public List<ResponseProductDto> getAllProducts() throws DBException {
        List<Product> productList = productDao.queryAllProducts();
        if (productList.isEmpty()) {
            throw new DBException("Cannot query products from database.");
        }
        return productList.stream()
                .map(mapper::fromProductToResponseProductDto)
                .toList();
    }

    @Override
    public int deleteProductById(Integer id) {
        return 0;
    }
}
