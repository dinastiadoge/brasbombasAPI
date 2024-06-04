package com.sgbd.repository;

import com.sgbd.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}