package com.sgbd.service;

import com.sgbd.Exceptions.ProdutoExistenteException;
import com.sgbd.entity.Compra;
import com.sgbd.entity.Produto;
import com.sgbd.repository.CompraRepository;
import com.sgbd.repository.ProdutoRepository;
import com.sgbd.request.AtualizarCompraRequest;
import com.sgbd.request.AtualizarProdutoRequest;
import com.sgbd.request.CadastrarCompraRequest;
import com.sgbd.request.CadastrarProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompraService {


    //TODO ATUALIZAR OS MÉTODOS DO SERVICE PARA QUE O CONTROLLER NAO DE ERRO (PEGAR OS MÉTODOS DO PRODUTO)

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> obterCompras() {
        return this.compraRepository.findAll();
    }

    public void excluirCompra(Long id) {
        this.compraRepository.deleteById(id);
    }

    public Optional<Compra> obterCompra(Long id) {
        return this.compraRepository.findById(id);
    }

    public Compra salvarCompra(CadastrarCompraRequest compraRequest) {

        Compra compra = Compra.builder()
                .cliente(compraRequest.getCliente().toString())
                .produto(compraRequest.getProduto_nome())
                .quantidade(compraRequest.getQuantidade())
                .build();

        return this.compraRepository.save(compra);

    }

    public Compra atualizarCompra(Long id, AtualizarCompraRequest request) {
        Compra compra = this.compraRepository.findById(id).get();
        compra.setCliente(request.getCliente().toString());
        compra.setProduto(request.getProduto_nome());
        compra.setQuantidade(request.getQuantidade());
        this.compraRepository.save(compra);

        return compra;
    }

}
