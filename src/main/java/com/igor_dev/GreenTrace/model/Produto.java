package com.igor_dev.GreenTrace.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, unique = true)
    private Long id_produto;
    
    @Column(name = "nome_produto")
    private String nome_produto;
    
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    
    @Column(name = "preco")
    private BigDecimal preco;
}