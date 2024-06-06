package com.sgbd.response;

import com.sgbd.status.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CadastrarBombaResponse {

    private Long OS;

    private String marca;

    private String modelo;

    private String potencia;

    private String voltagem;

    private String descricao;

    private String cliente_cpf;

    private StatusEnum status;

    private Double valor;
}
