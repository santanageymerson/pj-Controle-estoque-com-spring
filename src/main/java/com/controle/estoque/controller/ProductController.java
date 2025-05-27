package com.controle.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.estoque.model.Product;
import com.controle.estoque.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("list")
    public List<Product> listProduct(){
        return service.list();
    }
}
