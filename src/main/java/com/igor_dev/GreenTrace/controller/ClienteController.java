package com.igor_dev.GreenTrace.controller;

import java.util.List;
import java.util.Optional;

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

import com.igor_dev.GreenTrace.model.Clientes;
import com.igor_dev.GreenTrace.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Clientes>> findAllCliente(){
        return ResponseEntity.ok(clienteService.findAllCliente());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Clientes>> findClienteById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findClienteById(id));
    }

    @PostMapping
    public ResponseEntity<Clientes> createCliente(@RequestBody Clientes cliente){
        return ResponseEntity.ok(clienteService.createCliente(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity<Clientes> updateCliente(@PathVariable Long id, Clientes cliente){
        return ResponseEntity.ok(clienteService.updateCliente(id, cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
    
}
