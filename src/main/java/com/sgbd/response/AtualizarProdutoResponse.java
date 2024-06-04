package com.sgbd.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AtualizarProdutoResponse {

    private Long id;

    private String marca;

    private String nome;

    private Integer quantidade;


}