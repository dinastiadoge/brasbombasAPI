package com.sgbd.controller;


import com.sgbd.entity.Cliente;
import com.sgbd.service.ClienteService;
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
    public ResponseEntity<String> salvarCliente(@RequestBody Cliente cliente) {
        Cliente clientesalvo = clienteService.salvarCliente(cliente);

        return new ResponseEntity<>("Novo Cliente adicionado " + clientesalvo.getNome(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> atualizarCliente(@RequestBody Cliente cliente) {
        Cliente clientesalvo = clienteService.salvarCliente(cliente);
        return new ResponseEntity<>("Cliente atualizado " + clientesalvo.getNome(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obterClientes() {
        return new ResponseEntity<>(clienteService.obterCliente(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }

}