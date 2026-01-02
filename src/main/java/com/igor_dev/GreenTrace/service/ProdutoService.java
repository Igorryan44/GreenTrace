package com.igor_dev.GreenTrace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor_dev.GreenTrace.repository.ProdutoRepository;

@Service
public class ProdutoService {
    

    @Autowired
    private ProdutoRepository produtoRepository;
}
