package com.controle.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.estoque.model.Supplier;
import com.controle.estoque.service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("Supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @Operation(description = "listas todos usuário")
    @GetMapping("/list")
    public List<Supplier> list() {
        return service.list();
    }

    @Operation(description = "cadastra usuário")
    @PostMapping("/register")
    public ResponseEntity<Supplier> registerSupplier(@RequestBody Supplier suplier) {
        var resposta = service.registSupplier(suplier);
        return new ResponseEntity<>(resposta,HttpStatus.CREATED);
    }

    @Operation(description = "busca usuário por id")
    @GetMapping("/search/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Long id){
        var supplier = service.getSupplierById(id);
        if(supplier.isPresent()){
            return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(description = "atualiza usuário por id")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateSupplierById(@PathVariable Long id, @RequestBody Supplier suplier) {
        service.updateSupplierById(id, suplier);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(description = "delata usuário por id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupplierById(@PathVariable Long id){
        service.deleteSuplierById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    
    
}
