package com.igor_dev.GreenTrace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor_dev.GreenTrace.model.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos, Long>{}
