package com.sgbd.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AtualizarCompraResponse {

    private Long id;

    private Long cliente_cpf;

    private String produto_nome;

    private Integer quantidade;

}
