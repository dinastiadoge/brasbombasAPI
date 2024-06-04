package com.sgbd.repository;

import com.sgbd.entity.Bomba;
import com.sgbd.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaRepository extends JpaRepository<Bomba, Long> {
}