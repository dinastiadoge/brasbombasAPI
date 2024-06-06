package com.sgbd.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AtualizarClienteRequest {

    @Positive(message = "{cadastrar.cliente.request.cpf.obrigatorio}")
    private Long CPF;
    @NotBlank(message = "{cadastrar.cliente.request.nome.obrigatorio}")
    private String nome;
    @NotBlank(message = "{cadastrar.cliente.request.cep.obrigatorio}")
    private String cep;
    @Positive(message = "{cadastrar.cliente.request.numero.obrigatorio}")
    private Integer numero;
    @NotBlank(message = "{cadastrar.cliente.request.telefone.obrigatorio}")
    private String telefone;

}
