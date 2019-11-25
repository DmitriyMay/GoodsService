package main.service;

import main.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();
    Optional<Product> getProductById(int id);
    int addProductAndGetId(Product product);
    int updateProduct(Product product);
    int deleteProduct(int id);



}
