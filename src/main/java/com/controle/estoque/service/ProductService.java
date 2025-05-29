package com.controle.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.model.Product;
import com.controle.estoque.repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> list(){
        return  repository.findAll();
    }

}
