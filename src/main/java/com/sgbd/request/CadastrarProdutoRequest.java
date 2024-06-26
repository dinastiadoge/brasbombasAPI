package com.sgbd.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
public class CadastrarProdutoRequest {

    @NotBlank(message = "{cadastrar.produto.request.nome.obrigatorio}")
    private String nome;
    @Length(message = "{cadastrar.produto.request.marca}")
    private String marca;
    @NotNull(message = "{cadastrar.produto.request.quantidade}") //validaçoes
    private Integer quantidade;

}
