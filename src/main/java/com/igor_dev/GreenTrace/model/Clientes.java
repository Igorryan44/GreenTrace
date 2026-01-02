package com.igor_dev.GreenTrace.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Clientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false, unique = true)
    private Long cliente_id;
    
    @Column(name = "nome_cliente")
    private String nome_cliente;
    
    @Column(name = "cpf", unique = true)
    private String cpf;
    
    @Column(name = "contato_cliente", unique = true)
    private String contato_cliente;
    
    @OneToMany(mappedBy="cliente")
    @JsonManagedReference
    @Column(name = "compras")
    private List<Vendas> compras = new ArrayList<Vendas>();
}
