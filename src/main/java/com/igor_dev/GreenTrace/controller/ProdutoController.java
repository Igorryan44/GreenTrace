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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.model.Produtos;
import com.igor_dev.GreenTrace.service.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produtos> findAllProdutos(){
        return produtoService.findAllProdutos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Produtos>> findProdutoById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.findProdutoById(id));
    }


    @PostMapping
    public ResponseEntity<Produtos> createProduto(Funcionarios funcionario, Produtos produto){
        return ResponseEntity.ok(produtoService.createProduto(funcionario, produto));
    }

    @PutMapping("{id}")
    public ResponseEntity<Produtos> updateProduto(@PathVariable Long id, Produtos produto){
        return ResponseEntity.ok(produtoService.updateProduto(id, produto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
