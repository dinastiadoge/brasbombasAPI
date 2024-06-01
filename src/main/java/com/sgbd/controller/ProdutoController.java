package com.sgbd.controller;


import com.sgbd.entity.Produto;
import com.sgbd.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    //TODO METODOS DE ADICIONAR, ATUALIZAR E DELETAR?

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<String> salvarProduto(@RequestBody Produto produto) {
        Produto produtosalvo = produtoService.salvarProduto(produto);

        return new ResponseEntity<>("Novo produto adicionado " + produtosalvo.getNome(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> atualizarUsuario(@RequestBody Produto produto) {
        Produto produtosalvo = produtoService.salvarProduto(produto);
        return new ResponseEntity<>("Produto atualizado " + produtosalvo.getNome(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterUsuarios() {
        return new ResponseEntity<>(produtoService.obterProdutos(), HttpStatus.OK);
    }


}
