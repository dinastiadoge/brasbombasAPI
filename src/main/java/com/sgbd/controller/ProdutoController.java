package com.sgbd.controller;


import com.sgbd.entity.Produto;
import com.sgbd.request.CadastrarProdutoRequest;
import com.sgbd.response.CadastrarProdutoResponse;
import com.sgbd.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<String> salvarProduto(@Valid @RequestBody CadastrarProdutoRequest request) {
        Produto produtosalvo = produtoService.salvarProduto(request);

        CadastrarProdutoResponse response = CadastrarProdutoResponse.builder()
                .id(produtosalvo.getId())
                .marca(produtosalvo.getMarca())
                .nome(produtosalvo.getNome())
                .quantidade(produtosalvo.getQuantidade())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);


        return new ResponseEntity<>("Novo produto adicionado " + produtosalvo.getNome(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> atualizarProduto(@RequestBody Produto produto) {
        Produto produtosalvo = produtoService.salvarProduto(produto);
        return new ResponseEntity<>("Produto atualizado " + produtosalvo.getNome(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterProdutos() {
        return new ResponseEntity<>(produtoService.obterProdutos(), HttpStatus.OK);
    }

    @DeleteMapping
    public void excluirProduto(@RequestBody Produto produto) {
        produtoService.excluirProduto(produto);
    }



}
