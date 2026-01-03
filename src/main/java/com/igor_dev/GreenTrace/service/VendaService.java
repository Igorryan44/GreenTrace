package com.igor_dev.GreenTrace.service;

import java.time.OffsetDateTime;
import java.util.List;

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
            venda.getCliente(),
            venda.getProduto(),
            venda.getFuncionario(),
            venda.getCriadoEm()
        );
    }

    public VendaResponseDTO criarVenda(VendaRequestDTO vendaRequestDTO) {
        Vendas venda = Vendas.builder()
        .cliente(vendaRequestDTO.cliente())
        .produto(vendaRequestDTO.produto())
        .funcionario(vendaRequestDTO.funcionario())
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
        .cliente(vendaRequestDTO.cliente() != null ? vendaRequestDTO.cliente() : vendaEntity.cliente())
        .produto(vendaRequestDTO.produto() != null ? vendaRequestDTO.produto() : vendaEntity.produto())
        .funcionario(vendaRequestDTO.funcionario() != null ? vendaRequestDTO.funcionario() : vendaEntity.funcionario())
        .build();

        return toResponse(vendaRepository.save(vendaUpdated));
    }


}
