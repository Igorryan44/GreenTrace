package com.igor_dev.GreenTrace.dto;

import com.igor_dev.GreenTrace.model.Clientes;
import com.igor_dev.GreenTrace.model.Produtos;

public class VendaRequestDTO {
    
    private Long id_venda;
    
    private Clientes cliente;
    
    private Produtos produto;

    public Long getId_venda() {
        return id_venda;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public Produtos getProduto() {
        return produto;
    }
}
