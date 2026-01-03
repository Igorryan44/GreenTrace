package com.igor_dev.GreenTrace.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "id_cliente", nullable = false, unique = true)
    private Long id_cliente;
    
    @Column(name = "nome_cliente")
    private String nome_cliente;
    
    @Column(name = "cpf", unique = true)
    private String cpf;
    
    @Column(name = "contato_cliente", unique = true)
    private String contato_cliente;
    
    @OneToMany(mappedBy="clientes")
    @JsonManagedReference
    private List<Vendas> venda = new ArrayList<Vendas>();
}
