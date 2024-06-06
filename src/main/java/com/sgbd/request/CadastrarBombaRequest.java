package com.sgbd.request;

import com.sgbd.entity.Cliente;
import com.sgbd.status.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarBombaRequest {

    @Positive(message = "{cadastrar.bomba.request.os.positiva}")
    @NotNull(message = "{cadastrar.bomba.request.os.obrigatorio}")
    private Long OS;

    @NotBlank(message = "{cadastrar.bomba.request.marca.obrigatorio}")
    private String marca;

    @NotBlank(message = "{cadastrar.bomba.request.modelo.obrigatorio}")
    private String modelo;

    @NotBlank(message = "{cadastrar.bomba.request.potencia.obrigatorio}")
    private String potencia;

    @NotBlank(message = "{cadastrar.bomba.request.voltagem.obrigatorio}")
    private String voltagem;

    @NotBlank(message = "{cadastrar.bomba.request.descricao.obrigatorio}")
    private String descricao;

    @NotBlank(message = "{cadastrar.bomba.request.clientecpf.obrigatorio}")
    private String cliente_cpf;

    @NotNull(message = "{cadastrar.bomba.request.status.obrigatorio}")
    private StatusEnum status;

    @Positive(message = "{cadastrar.bomba.request.valor.positivo}")
    private Double valor;

}