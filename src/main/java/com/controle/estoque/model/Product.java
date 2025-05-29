package com.controle.estoque.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="produto")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="nome_produto")
    private String name;
    @Column(name="descição")
    private String description;
    @Column(name="preço") 
    private Double price;
    @Column(name="quantidade")
    private Integer amount;

}
