package com.sgbd.repository;

import com.sgbd.entity.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {



}