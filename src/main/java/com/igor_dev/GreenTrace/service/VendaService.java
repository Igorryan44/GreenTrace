package com.igor_dev.GreenTrace.service;

import java.time.OffsetDateTime;
import java.util.List;

import com.igor_dev.GreenTrace.model.Clientes;
import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_dev.GreenTrace.dto.VendaRequestDTO;
import com.igor_dev.GreenTrace.dto.VendaResponseDTO;
import com.igor_dev.GreenTrace.model.Vendas;
import com.igor_dev.GreenTrace.repository.VendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    
    public VendaResponseDTO toResponse(Vendas venda){
        return new VendaResponseDTO(
            venda.getId_venda(),
                venda.getClientes(),
                (List<Produtos>) venda.getProdutos(),
                (List<Funcionarios>) venda.getFuncionarios(),
            venda.getCriadoEm()
        );
    }

    public VendaResponseDTO criarVenda(VendaRequestDTO vendaRequestDTO) {
        Vendas venda = Vendas.builder()
        .clientes(vendaRequestDTO.cliente())
        .produtos((Produtos) vendaRequestDTO.produto())
        .funcionarios((Funcionarios) vendaRequestDTO.funcionario())
        .criadoEm(OffsetDateTime.now())
        .build();

        return toResponse(vendaRepository.save(venda));
    }



    public VendaResponseDTO findVendaById(Long id){
        Vendas venda = vendaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar a venda com o id: " + id));
        return toResponse(venda);
    }

    
    public VendaResponseDTO findAllVenda(){
        List<Vendas> vendas = vendaRepository.findAll();
        return toResponse((Vendas) vendas);
    }

    public void deletarVenda(Long id){
        if(!vendaRepository.existsById(id)){
            throw new EntityNotFoundException("Venda não encontrada");
        }
        
        vendaRepository.deleteById(id);
    }


    public VendaResponseDTO updateVenda (Long id, VendaRequestDTO vendaRequestDTO){
        VendaResponseDTO vendaEntity = findVendaById(id);
        
        Vendas vendaUpdated = Vendas.builder()
        .id_venda(id)
        .clientes(vendaRequestDTO.cliente() != null ? vendaRequestDTO.cliente() : vendaEntity.cliente())
        .produtos((Produtos) (vendaRequestDTO.produto() != null ? vendaRequestDTO.produto() : vendaEntity.produto()))
        .funcionarios((Funcionarios) (vendaRequestDTO.funcionario() != null ? vendaRequestDTO.funcionario() : vendaEntity.funcionario()))
        .build();

        return toResponse(vendaRepository.save(vendaUpdated));
    }


}
