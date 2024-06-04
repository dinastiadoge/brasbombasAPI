package com.sgbd.repository;

import com.sgbd.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByNomeAndMarca(String nome, String marca);
    Produto findByNome(String nome);
}
