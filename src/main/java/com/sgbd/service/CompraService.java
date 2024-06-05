package com.sgbd.service;

import com.sgbd.Exceptions.ClienteInexistenteException;
import com.sgbd.Exceptions.ProdutoInexistenteException;
import com.sgbd.entity.Cliente;
import com.sgbd.entity.Compra;
import com.sgbd.entity.Produto;
import com.sgbd.repository.ClienteRepository;
import com.sgbd.repository.CompraRepository;
import com.sgbd.repository.ProdutoRepository;
import com.sgbd.request.AtualizarCompraRequest;
import com.sgbd.request.CadastrarCompraRequest;
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
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ProdutoService produtoService;

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

        Produto produto = produtoRepository.findByNome(compraRequest.getProduto_nome());
        Optional<Cliente> cliente = clienteRepository.findById(compraRequest.getCliente());
        if (cliente.isEmpty()) {
            throw new ClienteInexistenteException("Cliente inexistente no banco de dados, cadastre ele antes para cadastrar uma compra");
        }
        if (produto == null) {
            throw new ProdutoInexistenteException("Produto inexistente no banco de dados, cadastre ele antes para cadastrar uma compra");
        }

        atualizarQuantidadeProduto(produto.getId(), produto.getQuantidade() - compraRequest.getQuantidade());

        Compra compra = Compra.builder()
                .cliente(compraRequest.getCliente().toString())
                .produto(compraRequest.getProduto_nome())
                .quantidade(compraRequest.getQuantidade())
                .build();

        return this.compraRepository.save(compra);

    }

    protected void atualizarQuantidadeProduto(long id, Integer valor) {
        Produto produtosalvo = produtoService.atualizarQuantidadeProduto(id, valor);
    }

    public Compra atualizarCompra(Long id, AtualizarCompraRequest request) {
        Compra compra = this.compraRepository.findById(id).get();
        Produto produto = produtoService.findByNome(request.getProduto_nome());

        atualizarQuantidadeProduto(produto.getId(), produto.getQuantidade() + compra.getQuantidade());
        atualizarQuantidadeProduto(produto.getId(), produto.getQuantidade() - request.getQuantidade());
        compra.setCliente(request.getCliente().toString());
        compra.setProduto(request.getProduto_nome());
        compra.setQuantidade(request.getQuantidade());
        this.compraRepository.save(compra);

        return compra;
    }

}
