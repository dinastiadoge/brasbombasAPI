package com.sgbd.service;


import com.sgbd.entity.Produto;
import com.sgbd.repository.ProdutoRepository;
import com.sgbd.request.CadastrarProdutoRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(CadastrarProdutoRequest request) {
        return this.produtoRepository.save(request);
    }

    public List<Produto> obterProdutos() {
        return this.produtoRepository.findAll();
    }

    public void excluirProduto(Produto produto) {
        this.produtoRepository.deleteById(produto.getId());
    }

}
