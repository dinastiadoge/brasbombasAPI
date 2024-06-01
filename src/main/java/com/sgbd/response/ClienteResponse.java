package com.sgbd.response;

import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Builder
public class ClienteResponse {

    private Long id;

    private String marca;

    private String nome;

    private Long quantidade;

}
