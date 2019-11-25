package main.controller;

import main.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import main.service.ProductService;

@Controller
public class DefaulController {

    @Autowired
    @Qualifier("dataService")
    ProductService service;

    @RequestMapping("/")
    public String index(Model model) {

        List<Product> products = service.getAllProduct();
        model.addAttribute("products", products);

        return "index";
    }
}
