package main.dao;

import main.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    List<Product> selectAllProduct();
    Optional<Product> selectProduct(int id);
    int addProductAndGetId(Product product);
    int updateProduct(Product product);
    int deleteProduct(int id);
}
