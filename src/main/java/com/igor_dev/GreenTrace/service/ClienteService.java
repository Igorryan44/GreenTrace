package com.igor_dev.GreenTrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_dev.GreenTrace.model.Clientes;
import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Clientes createCliente(Funcionarios funcionario, Clientes cliente){
        return clienteRepository.save(cliente);
    }

    public List<Clientes> findAllCliente(){
        return clienteRepository.findAll();
    }

    public Optional<Clientes> findClienteById(Long id){
        return clienteRepository.findById(id);
    }


    public Clientes updateCliente (Long id, Clientes cliente){
        Clientes clienteEntity = findClienteById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        Clientes clienteUpdated = Clientes.builder()
        .cliente_id(id)
        .nome_cliente(cliente.getNome_cliente() != null ? cliente.getNome_cliente() : clienteEntity.getNome_cliente())
        .cpf(cliente.getCpf() != null ? cliente.getCpf() : clienteEntity.getCpf())
        .contato_cliente(cliente.getContato_cliente() != null ? cliente.getContato_cliente() : clienteEntity.getContato_cliente())
        .compras(clienteEntity.getCompras())
        .build();

        return clienteRepository.save(clienteUpdated);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

}
