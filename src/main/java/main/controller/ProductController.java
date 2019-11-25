package main.controller;

import main.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import main.service.ProductService;

@RestController
public class ProductController {

    private static final int SIGN_OF_COMPLETED_REQUEST = 1;

    @Autowired
    @Qualifier("dataService")
    private ProductService service;


    @PostMapping("/products/")
    public ResponseEntity addProduct(Product product) {

        int id = service.addProductAndGetId(product);
        String url = String.format("/products/%s", id);

        Map<String, String> headers = new HashMap<>();
        headers.put("Location", url);

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProduct(@PathVariable int id) {
        Optional<Product> optionalProduct = service.getProductById(id);
        return optionalProduct.map(product -> new ResponseEntity(product, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PutMapping("/products/")
    public ResponseEntity updateProduct(Product product) {

        int jdbcCode = service.updateProduct(product);

        return jdbcCode == SIGN_OF_COMPLETED_REQUEST ?
                ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body(null) :
                ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body(null);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        int jdbcCode = service.deleteProduct(id);
        return jdbcCode == SIGN_OF_COMPLETED_REQUEST ?
                ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body(null) :
                ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body(null);
    }
}
