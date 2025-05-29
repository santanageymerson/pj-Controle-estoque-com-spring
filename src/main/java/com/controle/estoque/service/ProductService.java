package com.controle.estoque.service;

import java.util.List;
import java.util.Optional;

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

    public Product registeProduct( Product product){
        var resposta = repository.save(product);
        return resposta;
    }

    public Optional<Product> getProductById(Long id){
         return repository.findById(id);
    }

    public void updateProductById(Long id,Product product){
        Optional<Product> productExists = repository.findById(id);
        Product productEntity = productExists.get();
        if(productExists.isPresent()){
            if(product.getName()!= null){
                productEntity.setName(product.getName());
            }
            if(product.getDescription()!= null){
                productEntity.setDescription(product.getDescription());
            }
            if(product.getPrice()!=null){
                productEntity.setPrice(product.getPrice());
            }
            if(product.getAmount()!= null){
                productEntity.setAmount(product.getAmount());
            }
            repository.save(productEntity);
        }
    }
    
    public void deleteProductById(Long id){
        var productExist = repository.existsById(id);
        if(productExist){
            repository.deleteById(id);
        }
    }
}
