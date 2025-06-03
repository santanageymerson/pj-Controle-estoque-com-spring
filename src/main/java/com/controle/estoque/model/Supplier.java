package com.controle.estoque.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "fornecedor")
@Data
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SupplierId;
    @Column(name="name")
    private String name;

    @Column(name ="cnpj")
    private String cnpj;

    @Column(name = "contato")
    private String contact;
    
    @Column(name = "email")
    private String email;

}
