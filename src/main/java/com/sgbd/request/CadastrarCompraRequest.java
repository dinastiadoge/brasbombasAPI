package com.sgbd.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarCompraRequest {

    @Positive(message = "{cadastrar.compra.request.cliente_cpf.obrigatorio}")
    private Long cliente;
    @NotBlank(message = "{cadastrar.compra.request.produto.obrigatorio}")
    private String produto_nome;
    @NotNull(message = "{cadastrar.compra.request.quantidade}")
    private Integer quantidade;
}
