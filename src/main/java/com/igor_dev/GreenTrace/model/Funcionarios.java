package com.igor_dev.GreenTrace.model;

import java.time.OffsetDateTime;

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
