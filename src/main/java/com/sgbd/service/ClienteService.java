package com.sgbd.service;


import com.sgbd.Exceptions.ClienteInexistenteException;
import com.sgbd.Exceptions.ProdutoExistenteException;
import com.sgbd.entity.Cliente;
import com.sgbd.repository.ClienteRepository;
import com.sgbd.request.AtualizarClienteRequest;
import com.sgbd.request.CadastrarClienteRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(CadastrarClienteRequest request) {


        Optional<Cliente> clienteValidacao = clienteRepository.findById(request.getCpf());
        if (clienteValidacao.isPresent()) {
            throw new ProdutoExistenteException("Já existe esse cliente no banco de dados");
        }

        Cliente cliente = Cliente.builder()
                .CPF(request.getCpf())
                .nome(request.getNome())
                .cep(request.getCep())
                .numero(request.getNumero())
                .telefone(request.getTelefone())
                .build();

        return this.clienteRepository.save(cliente);

    }

    public List<Cliente> obterClientes() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> obterCliente(Long id) {
        return this.clienteRepository.findById(id);
    }

    public void excluirCliente(Long cliente_id) {
        Optional<Cliente> clienteValidacao = clienteRepository.findById(cliente_id);
        if (clienteValidacao.isEmpty()) {
            throw new ClienteInexistenteException("Cliente Inexistente!");
        }

        this.clienteRepository.deleteById(cliente_id);
    }

    public Cliente atualizarCliente(Long id, AtualizarClienteRequest request) {
        Cliente cliente = this.clienteRepository.findById(id).get();
        cliente.setNome(request.getNome());
        cliente.setCep(request.getCep());
        cliente.setTelefone(request.getTelefone());
        cliente.setNumero(request.getNumero());
        this.clienteRepository.save(cliente);
        return cliente;
    }
}