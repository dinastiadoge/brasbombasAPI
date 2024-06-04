package com.sgbd.controller;

import com.sgbd.Exceptions.ClienteInexistenteException;
import com.sgbd.Exceptions.CompraInexistenteException;
import com.sgbd.Exceptions.ProdutoExistenteException;
import com.sgbd.Exceptions.ProdutoInexistenteException;
import com.sgbd.entity.Cliente;
import com.sgbd.entity.Compra;
import com.sgbd.entity.Produto;
import com.sgbd.repository.ProdutoRepository;
import com.sgbd.request.AtualizarCompraRequest;
import com.sgbd.request.CadastrarCompraRequest;
import com.sgbd.response.AtualizarCompraResponse;
import com.sgbd.response.CadastrarCompraResponse;
import com.sgbd.service.ClienteService;
import com.sgbd.service.CompraService;
import com.sgbd.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraService compraService;
    @Autowired
    ProdutoService produtoService;
    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<CadastrarCompraResponse> salvarCompra(@Valid @RequestBody CadastrarCompraRequest request) {

        Compra Compra = compraService.salvarCompra(request);
        Produto produto = produtoService.findByNome(request.getProduto_nome());
        Optional<Cliente> cliente =  clienteService.obterCliente(request.getCliente());
        if (cliente.isEmpty()){
            throw new ClienteInexistenteException("Cliente inexistente no banco de dados, cadastre ele antes para cadastrar uma compra");
        }
        if(produto == null){
            throw new ProdutoInexistenteException("Produto inexistente no banco de dados, cadastre ele antes para cadastrar uma compra");
        }

        produto.setQuantidade(produto.getQuantidade() - request.getQuantidade());

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

        Produto produto = produtoService.findByNome(request.getProduto_nome());
        Optional<Compra> compraAntiga = compraService.obterCompra(id);
        if (compraAntiga.isEmpty()) {
            throw new CompraInexistenteException("Essa compra não existe");
        }

        produto.setQuantidade(produto.getQuantidade() + compraAntiga.get().getQuantidade());

        AtualizarCompraResponse response = AtualizarCompraResponse.builder()
                .cliente_cpf(request.getCliente())
                .produto_nome(request.getProduto_nome())
                .quantidade(request.getQuantidade())
                .build();

        produto.setQuantidade(produto.getQuantidade() - request.getQuantidade());

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
