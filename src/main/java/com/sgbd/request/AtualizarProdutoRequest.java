package com.sgbd.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AtualizarProdutoRequest {
    @NotBlank(message = "{cadastrar.produto.request.nome.obrigatorio}")
    private String nome;
    @NotBlank(message = "{cadastrar.produto.request.marca}")
    private String marca;
    @NotNull(message = "{cadastrar.produto.request.quantidade}") //validaçoes
    private Integer quantidade;
}
