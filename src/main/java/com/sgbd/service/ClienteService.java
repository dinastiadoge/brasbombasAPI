//package com.sgbd.service;
//
//
//import com.sgbd.entity.Cliente;
//import com.sgbd.repository.ClienteRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class ClienteService {
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    public Cliente salvarCliente(Cliente cliente) {
//        return this.clienteRepository.save(cliente);
//    }
//
//    public List<Cliente> obterCliente() {
//        return this.clienteRepository.findAll();
//    }
//
//    public void excluirCliente(Cliente cliente) {
//        this.clienteRepository.deleteById(cliente.getCPF());
//    }
//
//}
