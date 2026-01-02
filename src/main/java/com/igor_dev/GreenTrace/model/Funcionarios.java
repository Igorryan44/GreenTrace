package com.igor_dev.GreenTrace.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Funcionarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @OneToMany(mappedBy = "funcionario")
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

}
