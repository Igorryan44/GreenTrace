package com.igor_dev.GreenTrace.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Produtos {

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
    
    @Column(name = "data_cadastro")
    private OffsetDateTime data_cadastro = OffsetDateTime.now();

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    @JsonBackReference
    private Funcionarios funcionario;
}