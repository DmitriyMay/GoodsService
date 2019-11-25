package main.service;

import main.model.Product;
import main.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dataService")
public class ImplProductService implements ProductService {

    @Autowired
    @Qualifier("productDao")
    ProductDAO productDAO;


    @Override
    public List<Product> getAllProduct() {
        return productDAO.selectAllProduct();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productDAO.selectProduct(id);
    }

    @Override
    public int addProductAndGetId(Product product) {
        return productDAO.addProductAndGetId(product);
    }


    @Override
    public int updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public int deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }
}
