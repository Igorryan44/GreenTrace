package com.igor_dev.GreenTrace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor_dev.GreenTrace.dto.VendaRequestDTO;
import com.igor_dev.GreenTrace.dto.VendaResponseDTO;
import com.igor_dev.GreenTrace.service.VendaService;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendaController {
    
    @Autowired
    private VendaService vendaService;


    @PostMapping
    public VendaResponseDTO criarVenda(@RequestBody VendaRequestDTO venda){
        return vendaService.criarVenda(venda);
    }

    @GetMapping("{id}")
    public ResponseEntity<VendaResponseDTO> findVendaById(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.findVendaById(id));
    }

    @GetMapping
    public ResponseEntity<VendaResponseDTO> findAllVenda(){
        return ResponseEntity.ok(vendaService.findAllVenda());
    }

    @PutMapping("{id}")
    public ResponseEntity<VendaResponseDTO> updateVenda(@PathVariable Long id, VendaRequestDTO venda){
        return ResponseEntity.ok(vendaService.updateVenda(id, venda));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}
