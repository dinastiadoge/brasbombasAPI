package com.sgbd.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "Bombas")
@Data
@Getter
@Setter
@Builder
public class Bomba implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public Bomba() {
    }

    public Bomba(Long OS, String marca, String modelo, String potencia, String voltagem, String descricao) {
        this.OS = OS;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.voltagem = voltagem;
        this.descricao = descricao;
    }

    @Id
    @Column(nullable = false, unique = true)
    private Long OS;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String potencia;

    @Column(nullable = false)
    private String voltagem;

    @Column(nullable = false)
    private String descricao;
}