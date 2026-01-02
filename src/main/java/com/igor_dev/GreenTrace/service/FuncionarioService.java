package com.igor_dev.GreenTrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionarios createFuncionario(Funcionarios funcionario){
        return funcionarioRepository.save(funcionario);
    }
    
    public List<Funcionarios> findAllFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionarios> findFuncionarioById(Long id){
        return funcionarioRepository.findById(id);
    }

    public Funcionarios updateFuncionario (Long id, Funcionarios funcionario){
        Funcionarios funcionarioEntity = findFuncionarioById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        Funcionarios funcionarioUpdated = Funcionarios.builder()
        .id(id)
        .nome(funcionario.getNome() != null ? funcionario.getNome() : funcionarioEntity.getNome())
        .cpf(funcionario.getCpf() != null ? funcionario.getCpf() : funcionarioEntity.getCpf())
        .contato(funcionario.getContato() != null ? funcionario.getContato() : funcionarioEntity.getContato())
        .ultima_atualizacao(funcionario.getUltima_atualizacao() != null ? funcionario.getUltima_atualizacao() : funcionarioEntity.getUltima_atualizacao())
        .build();

        return funcionarioRepository.save(funcionarioUpdated);
    }

    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }
}
