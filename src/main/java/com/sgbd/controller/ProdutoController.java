package com.sgbd.controller;

import com.sgbd.entity.Produto;
import com.sgbd.request.AtualizarProdutoRequest;
import com.sgbd.request.CadastrarProdutoRequest;
import com.sgbd.response.AtualizarProdutoResponse;
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
    public ResponseEntity<CadastrarProdutoResponse> salvarProduto(@Valid @RequestBody CadastrarProdutoRequest request) {
        Produto produtosalvo = produtoService.salvarProduto(request);

        CadastrarProdutoResponse response = CadastrarProdutoResponse.builder().id(produtosalvo.getId()).marca(produtosalvo.getMarca()).nome(produtosalvo.getNome()).quantidade(produtosalvo.getQuantidade()).build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AtualizarProdutoResponse> AtualizarTarefa(@PathVariable Long id, @Valid @RequestBody AtualizarProdutoRequest request) {
        Produto produtosalvo = produtoService.atualizarProduto(id, request);
        AtualizarProdutoResponse response = AtualizarProdutoResponse.builder()
                .id(produtosalvo.getId())
                .marca(produtosalvo.getMarca())
                .nome(produtosalvo.getNome())
                .quantidade(produtosalvo.getQuantidade())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterProdutos() {
        return new ResponseEntity<>(produtoService.obterProdutos(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }

}


