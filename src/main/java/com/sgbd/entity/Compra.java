package com.sgbd.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Compras")
@Data
@Getter
@Setter
@Builder
public class Compra implements Serializable {

    public Compra() {
    }

    public Compra(Long id, Integer quantidade, LocalTime dataCriacao, Cliente cliente, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
        this.produto = produto;
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @CreationTimestamp
    private LocalTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;




}
