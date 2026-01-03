package com.igor_dev.GreenTrace.dto;

import java.time.OffsetDateTime;

import com.igor_dev.GreenTrace.model.Clientes;
import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.model.Produtos;

public record VendaResponseDTO(

    Long id_venda,
    
    Clientes cliente,
    
    Produtos produto,

    Funcionarios funcionario,

    OffsetDateTime criadoEm

) {
    
}
