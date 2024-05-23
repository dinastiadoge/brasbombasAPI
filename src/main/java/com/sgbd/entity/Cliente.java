package com.sgbd.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "clientes")
@Data
@Getter
@Setter
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID= 1L;

    @Id
    @Column(nullable = false, length = 11)
    private String cpf;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idInterno;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(length = 50)
    private String bairro;

    @Column(length = 50)
    private String cidade;

    @Column(length = 50)
    private String rua;

    @Column(length = 10)
    private String nmr;

    @JoinColumn






}
