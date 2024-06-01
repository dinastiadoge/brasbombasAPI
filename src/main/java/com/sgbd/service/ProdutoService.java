package com.sgbd.service;


import com.sgbd.entity.Produto;
import com.sgbd.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
        return this.produtoRepository.save(produto);
    }

    public List<Produto> obterProdutos() {
        return this.produtoRepository.findAll();
    }


}
