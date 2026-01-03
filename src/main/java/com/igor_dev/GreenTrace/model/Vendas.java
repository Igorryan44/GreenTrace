package com.igor_dev.GreenTrace.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vendas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long id_venda;
    
    @ManyToOne
    @JoinColumn(name = "id_clientes")
    @JsonBackReference
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "id_produtos")
    @JsonBackReference
    private Produtos produtos;

    @ManyToOne
    @JoinColumn(name = "id_funcionarios")
    @JsonBackReference
    private Funcionarios funcionarios;

    @Column(name = "criado_em")
    private OffsetDateTime criadoEm = OffsetDateTime.now();

}
