package com.sgbd.request;

import com.sgbd.entity.Cliente;
import com.sgbd.status.StatusEnum;
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

    private String cliente_cpf;

    private StatusEnum status;

    private Double valor;


}
