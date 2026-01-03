package com.igor_dev.GreenTrace.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "id_produto", nullable = false, unique = true)
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
    @JoinColumn(name = "id_funcionarios")
    @JsonBackReference
    private Funcionarios funcionarios;

    @OneToMany(mappedBy = "produtos")
    @JsonManagedReference
    private List<Vendas> vendas = new ArrayList<Vendas>();
}