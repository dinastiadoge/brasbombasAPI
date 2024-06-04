package com.sgbd.controller;


import com.sgbd.entity.Cliente;
import com.sgbd.entity.Produto;
import com.sgbd.request.AtualizarClienteRequest;
import com.sgbd.request.AtualizarProdutoRequest;
import com.sgbd.request.CadastrarClienteRequest;
import com.sgbd.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody CadastrarClienteRequest cliente) {
        Cliente clientesalvo = clienteService.salvarCliente(cliente);

        return new ResponseEntity<>(clientesalvo, HttpStatus.CREATED);
    }
        // /clientes/id
    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id,@Valid @RequestBody AtualizarClienteRequest request) {
        Cliente clientesalvo = clienteService.atualizarCliente(id, request);
        return new ResponseEntity<>(clientesalvo, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obterClientes() {
        return new ResponseEntity<>(clienteService.obterClientes(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }

}