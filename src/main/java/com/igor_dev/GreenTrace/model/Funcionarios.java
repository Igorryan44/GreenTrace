package com.igor_dev.GreenTrace.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Funcionarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @JsonManagedReference
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome; 
    
    @Column(name = "cpf", unique = false)
    private String cpf; 
    
    @Column(name = "contato", unique = false)
    private String contato;
    
    @Column(name = "criado_em")
    private OffsetDateTime criado_em = OffsetDateTime.now();
    
    @Column(name = "ultima_atualizacao")
    private OffsetDateTime ultima_atualizacao = OffsetDateTime.now();

    @OneToMany(mappedBy = "funcionarios")
    @JsonManagedReference
    private List<Produtos> produtos = new ArrayList<Produtos>();

    @OneToMany(mappedBy = "funcionarios")
    @JsonManagedReference
    private List<Vendas> vendas = new ArrayList<Vendas>();

}
