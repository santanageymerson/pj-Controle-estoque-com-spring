package com.controle.estoque.controller;

//import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.estoque.model.Product;
import com.controle.estoque.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(description = "listas todos usuário")
    @GetMapping("list")
    public List<Product> listProduct(){
        return service.list();
    }

    @Operation(description = "cadastra usuário")
    @PostMapping("register")
    public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
        var resposta = service.registeProduct(product);
        
        return new ResponseEntity<>(resposta,HttpStatus.CREATED);
        //return ResponseEntity.created(URI.create(resposta.toString())).build();
    }

    @Operation(description = "busca usuário por id")
    @GetMapping("search/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        var product = service.getProductById(id);
        if(product.isPresent()){
            return new ResponseEntity<>(product.get(),HttpStatus.OK);
        }
        else{
            return ResponseEntity.notFound().build(); // o recurso não foi encontrado erro 404
        }
        
    }
    
    @Operation(description = "atualiza usuário por id")
    @PutMapping("update/{id}")
    public ResponseEntity<Void> updateProductById(@PathVariable Long id, @RequestBody Product product) {
        service.updateProductById(id, product);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // solicitação processada mais não tem conteudo adicional 
    }

    @Operation(description = "delata usuário por id")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        service.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
