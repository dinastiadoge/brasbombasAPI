package com.sgbd.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AtualizarClienteRequest {

    @NotBlank(message = "{cadastrar.cliente.request.cpf.obrigatorio}")
    private Long CPF;
    @NotBlank(message = "{cadastrar.cliente.request.nome.obrigatorio}")
    private String nome;
    @NotBlank(message = "{cadastrar.cliente.request.cep.obrigatorio}")
    private String cep;
    @NotBlank(message = "{cadastrar.cliente.request.numero.obrigatorio}")
    private Integer numero;
    @NotBlank(message = "{cadastrar.cliente.request.telefone.obrigatorio}")
    private String telefone;

    //To Do: colocar isso no messages.properties e escrever as mensagens!
//    cadastrar.cliente.request.cpf.obrigatorio
//    cadastrar.cliente.request.nome.obrigatorio
//    cadastrar.cliente.request.cep.obrigatorio
//    cadastrar.cliente.request.numero.obrigatorio
//    cadastrar.cliente.request.telefone.obrigatorio
}
