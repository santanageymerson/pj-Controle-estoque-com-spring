package com.controle.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.model.Supplier;
import com.controle.estoque.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repository;

    public List<Supplier> list(){
        return repository.findAll();
    }
    
    public Supplier registSupplier(Supplier supplier){
        Supplier saveSupplier = repository.save(supplier);
        return saveSupplier;
    }
    public Optional<Supplier> getSupplierById(Long id){
        var getSupplier = repository.findById(id);
        return getSupplier;
    }
    public void updateSupplierById(Long id, Supplier supplier){
        Optional<Supplier> supplierExists = repository.findById(id);
        Supplier supplierEntity = supplierExists.get();
        if(supplierExists.isPresent()){
            if(supplier.getName()!=null){
                supplierEntity.setName(supplier.getName());
            }
            if(supplier.getEmail()!=null){
                supplierEntity.setEmail(supplier.getEmail());
            }
            if (supplier.getCnpj()!=null){
                supplierEntity.setCnpj(supplier.getCnpj());
            }
            if(supplier.getContact()!= null){
                supplierEntity.setContact(supplier.getContact());
            }
            repository.save(supplierEntity);
        }
    }

    public void deleteSuplierById(Long id){
        //Optional<Supplier> supplierExists = repository.findById(id);
        //if(supplierExists.isPresent()){
          //  repository.deleteById(id);
        //}
        Boolean supplierExists = repository.existsById(id);
        if (supplierExists){
            repository.deleteById(id);
        }
    }
}
