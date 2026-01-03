package com.igor_dev.GreenTrace.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Long id_venda;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Clientes cliente;
    
    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonBackReference
    private Produtos produto;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    @JsonBackReference
    private Funcionarios funcionario;

    @Column(name = "criado_em")
    private OffsetDateTime criadoEm = OffsetDateTime.now();

    


}
