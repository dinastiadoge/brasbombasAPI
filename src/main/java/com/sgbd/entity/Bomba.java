package com.sgbd.entity;


import com.sgbd.status.StatusEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


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

    public Bomba(Long OS, String marca, String modelo, String potencia, String voltagem, String descricao, String cliente, StatusEnum status, Double valor, LocalDate dataChegada, LocalDate dataAtualizacao) {
        this.OS = OS;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.voltagem = voltagem;
        this.descricao = descricao;
        this.cliente = cliente;
        this.status = status;
        this.valor = valor;
        this.dataChegada = dataChegada;
        this.dataAtualizacao = dataAtualizacao;
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

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private StatusEnum status;

    @Column
    private Double valor;

    @CreationTimestamp
    private LocalDate dataChegada;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;
}