//package com.sgbd.controller;
//
//
//import com.sgbd.entity.Cliente;
//import com.sgbd.service.ClienteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/clientes")
//public class ClienteController {
//
//    @Autowired
//    private ClienteService clienteService;
//
//    @PostMapping
//    public ResponseEntity<String> salvarCliente(@RequestBody Cliente cliente) {
//        Cliente produtosalvo = clienteService.salvarProduto(cliente);
//
//        return new ResponseEntity<>("Novo Cliente adicionado " + produtosalvo.getNome(), HttpStatus.CREATED);
//    }
//
//    @org.springframework.web.bind.annotation.PutMapping
//    public ResponseEntity<String> atualizarProduto(@RequestBody Cliente cliente) {
//        Cliente produtosalvo = clienteService.salvarProduto(cliente);
//        return new ResponseEntity<>("Cliente atualizado " + produtosalvo.getNome(), HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Cliente>> obterProdutos() {
//        return new ResponseEntity<>(clienteService.obterProdutos(), HttpStatus.OK);
//    }
//
//    @DeleteMapping
//    public void excluirProduto(@RequestBody Cliente cliente) {
//        clienteService.excluirProduto(cliente);
//    }
//
//}
