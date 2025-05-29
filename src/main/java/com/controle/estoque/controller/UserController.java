package com.controle.estoque.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.estoque.model.User;
import com.controle.estoque.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping(value ="/user")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(description = "listas todos usuário")
    @GetMapping(value = "/listar") 
    public List<User> listUser(){
        return service.listar();
    }

    @Operation(description = "cadastra usuário")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<User> createUser(@RequestBody User user){
        
        User resposta = service.createUser(user);
        return new ResponseEntity<>(resposta,HttpStatus.CREATED);
    }

    @Operation(description = "busca usuário por id")
    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        var user = service.getUserById(id);
        if (user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else{
            return ResponseEntity.notFound().build();
        } 
    }

    @Operation(description = "atualiza usuário por id")
    @PutMapping(value="/atualizar/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable("id") Long id, @RequestBody User user){
        service.updateUserById(id, user);
        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(description = "delata usuário por id")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    
  
}
