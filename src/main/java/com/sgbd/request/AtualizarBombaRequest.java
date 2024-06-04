package com.sgbd.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarBombaRequest {

    private Long OS;

    private String marca;

    private String modelo;

    private String potencia;

    private String voltagem;

    private String descricao;
}
