package com.igor_dev.GreenTrace.dto;

import java.time.OffsetDateTime;
import java.util.List;

import com.igor_dev.GreenTrace.model.Clientes;
import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.model.Produtos;

public record VendaRequestDTO (

    
    Clientes cliente,
    
    List<Produtos> produto,

    List<Funcionarios> funcionario,

    OffsetDateTime criadoEm

){}
