package com.sgbd.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Clientes")
@Data
@Getter
@Setter
public class Cliente implements Serializable {

    public Cliente() {
    }

    public Cliente(Long CPF, String nome, String cep, Integer numero, String telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.cep = cep;
        this.numero = numero;
        this.telefone = telefone;
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, unique = true)
    private Long CPF;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String telefone;


}
