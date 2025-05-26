package com.controle.estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "usuário")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="cantato")
    private String contact;
    @Column(name="cnpj")
    private String cnpj;
    @Column(name="senhausuário")
    private String passeworld;


}
