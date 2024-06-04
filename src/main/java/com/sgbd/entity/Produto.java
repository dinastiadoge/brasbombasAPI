package com.sgbd.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "Produtos")
@Data
@Getter
@Setter
@Builder
public class Produto implements Serializable {

    public Produto() {
    }

    public Produto(Long id, String nome, String marca, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Integer quantidade;

}
