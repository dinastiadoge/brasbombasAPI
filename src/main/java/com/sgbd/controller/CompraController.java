package com.sgbd.controller;

import com.sgbd.entity.Compra;
import com.sgbd.request.AtualizarCompraRequest;
import com.sgbd.request.CadastrarCompraRequest;
import com.sgbd.response.AtualizarCompraResponse;
import com.sgbd.response.CadastrarCompraResponse;
import com.sgbd.service.CompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraService compraService;

    @PostMapping
    public ResponseEntity<CadastrarCompraResponse> salvarCompra(@Valid @RequestBody CadastrarCompraRequest request) {

        Compra Compra = compraService.salvarCompra(request);


        CadastrarCompraResponse response = CadastrarCompraResponse.builder()
                .id(Compra.getId())
                .cliente_cpf(request.getCliente())
                .produto_nome(request.getProduto_nome())
                .quantidade(request.getQuantidade())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AtualizarCompraResponse> AtualizarCompra(@PathVariable Long id, @Valid @RequestBody AtualizarCompraRequest request) {

        Compra compra = compraService.atualizarCompra(id, request);

        AtualizarCompraResponse response = AtualizarCompraResponse.builder()
                .cliente_cpf(request.getCliente())
                .produto_nome(request.getProduto_nome())
                .quantidade(request.getQuantidade())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Compra>> obterCompras() {
        return new ResponseEntity<>(compraService.obterCompras(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void excluirCompra(@PathVariable Long id) {
        compraService.excluirCompra(id);
    }


}
