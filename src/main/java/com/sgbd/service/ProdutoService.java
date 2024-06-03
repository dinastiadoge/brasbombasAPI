package com.sgbd.service;


import com.sgbd.Exceptions.ProdutoExistenteException;
import com.sgbd.entity.Produto;
import com.sgbd.repository.ProdutoRepository;
import com.sgbd.request.AtualizarProdutoRequest;
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


        Produto produtoValidacao = produtoRepository.findByNomeAndMarca(request.getNome(), request.getMarca());
        if (produtoValidacao != null) {
            throw new ProdutoExistenteException("Já existe esse mesmo produto");
        }

        Produto produto = Produto.builder()
                .nome(request.getNome())
                .marca(request.getMarca())
                .quantidade(request.getQuantidade())
                .build();

        return this.produtoRepository.save(produto);

    }

    public List<Produto> obterProdutos() {
        return this.produtoRepository.findAll();
    }

    public void excluirProduto(Long produto_id) {
        this.produtoRepository.deleteById(produto_id);
    }


    public Produto atualizarProduto(Long id, AtualizarProdutoRequest request) {
        Produto produto = this.produtoRepository.findById(id).get();
        produto.setNome(request.getNome());
        produto.setMarca(request.getMarca());
        produto.setQuantidade(request.getQuantidade());

        this.produtoRepository.save(produto);

        return produto;
    }

    public void atualizarProdutoQuantidade(Long id, Integer quantidade) {
        Produto produto = this.produtoRepository.findById(id).get();

        produto.setQuantidade(quantidade);

        this.produtoRepository.save(produto);
    }


}