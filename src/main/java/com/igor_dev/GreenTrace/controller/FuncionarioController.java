package com.igor_dev.GreenTrace.controller;

import java.util.List;

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

import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.service.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping()
    public ResponseEntity<List<Funcionarios>> findAll(){
        return ResponseEntity.ok(funcionarioService.findAllFuncionario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionarios> findById(@PathVariable Long id){
        return ResponseEntity.ok(funcionarioService.findFuncionarioById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!")));
    }

    @PostMapping()
    public Funcionarios creatFuncionario(@RequestBody Funcionarios funcionario){
        return funcionarioService.createFuncionario(funcionario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Funcionarios> updateFuncionario(@PathVariable Long id, @RequestBody Funcionarios funcionario){
        return ResponseEntity.ok(funcionarioService.updateFuncionario(id, funcionario));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id){
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
