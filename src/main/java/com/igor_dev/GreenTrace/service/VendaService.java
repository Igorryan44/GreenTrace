package com.igor_dev.GreenTrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.model.Vendas;
import com.igor_dev.GreenTrace.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    
        public Vendas createVenda(Funcionarios funcionario, Vendas venda){
        return vendaRepository.save(venda);
    }

    public List<Vendas> findAllVenda(){
        return vendaRepository.findAll();
    }

    public Optional<Vendas> findVendaById(Long id){
        return vendaRepository.findById(id);
    }


    public Vendas updateVenda (Long id, Vendas venda){
        Vendas vendaEntity = findVendaById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        Vendas vendaUpdated = Vendas.builder()
        .id_venda(id)
        .cliente(venda.getCliente() != null ? venda.getCliente() : vendaEntity.getCliente())
        .produto(venda.getProduto() != null ? venda.getProduto() : vendaEntity.getProduto())
        .funcionario(venda.getFuncionario() != null ? venda.getFuncionario() : vendaEntity.getFuncionario())
        .build();

        return vendaRepository.save(vendaUpdated);
    }

    public void deletarVenda(Long id){
        vendaRepository.deleteById(id);
    }
}
