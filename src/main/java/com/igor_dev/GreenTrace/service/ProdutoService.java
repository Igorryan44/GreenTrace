package com.igor_dev.GreenTrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_dev.GreenTrace.model.Funcionarios;
import com.igor_dev.GreenTrace.model.Produtos;
import com.igor_dev.GreenTrace.repository.ProdutoRepository;

@Service
public class ProdutoService {
    

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produtos createProduto(Funcionarios funcionario, Produtos produto){
        return produtoRepository.save(produto);
    }

    public List<Produtos> findAllProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produtos> findProdutoById(Long id){
        return produtoRepository.findById(id);
    }


    public Produtos updateProduto (Long id, Produtos produto){
        Produtos produtoEntity = findProdutoById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        Produtos produtoUpdated = Produtos.builder()
        .id_produto(id)
        .nome_produto(produto.getNome_produto() != null ? produto.getNome_produto() : produtoEntity.getNome_produto())
        .quantidade(produto.getQuantidade() != null ? produto.getQuantidade() : produtoEntity.getQuantidade())
        .preco(produto.getPreco() != null ? produto.getPreco() : produtoEntity.getPreco())
        .data_cadastro(produtoEntity.getData_cadastro())
        .funcionario(produtoEntity.getFuncionario())
        .build();

        return produtoRepository.save(produtoUpdated);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
    
}
