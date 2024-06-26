package com.sgbd.service;


import com.sgbd.Exceptions.ProdutoExistenteException;
import com.sgbd.Exceptions.ValorInvalidoException;
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
    public Produto atualizarQuantidadeProduto(Long id, Integer valor) {

        if(valor<0){
            throw new ValorInvalidoException("Valor inválido! NÃO É PERMITIDO QUE HAJA QUANTIDADE NEGATIVA, VERIFIQUE SEU ESTOQUE E TENTE NOVAMENTE COM OUTRO VALOR");
        }

        Produto produto = this.produtoRepository.findById(id).get();
        produto.setQuantidade(valor);
        this.produtoRepository.save(produto);

        return produto;
    }

    public Produto findByNome(String produtoNome) {
        return this.produtoRepository.findByNome(produtoNome);
    }
}