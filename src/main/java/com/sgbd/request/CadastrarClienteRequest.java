package com.sgbd.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarClienteRequest {
    @Positive(message = "{cadastrar.cliente.request.cliente_cpf.obrigatorio}")
    private Long cpf;
    @NotBlank(message = "{cadastrar.cliente.request.nome.obrigatorio}")
    private String nome;
    @NotNull(message = "{cadastrar.cliente.request.cep}")
    private String cep;
    @NotNull(message = "{cadastrar.cliente.request.numero}")
    private Integer numero;
    @NotNull(message = "{cadastrar.cliente.request.telefone}")
    private String telefone;
}
