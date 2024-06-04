package com.sgbd.controller;


import com.sgbd.entity.Bomba;
import com.sgbd.request.AtualizarBombaRequest;
import com.sgbd.request.CadastrarBombaRequest;
import com.sgbd.service.BombaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bombas")
public class BombaController {
    @Autowired
    private BombaService bombaService;

    @PostMapping
    public ResponseEntity<Bomba> salvarBomba(@Valid @RequestBody CadastrarBombaRequest bomba) {
        Bomba bombasalva = bombaService.salvarBomba(bomba);

        return new ResponseEntity<>(bombasalva, HttpStatus.CREATED);
    }
    // /clientes/id
    @PutMapping("{id}")
    public ResponseEntity<Bomba> atualizarBomba(@PathVariable Long id, @Valid @RequestBody AtualizarBombaRequest request) {
        Bomba bombasalva = bombaService.atualizarBomba(id, request);
        return new ResponseEntity<>(bombasalva, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Bomba>> obterBombas() {
        return new ResponseEntity<>(bombaService.obterBombas(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void excluirBomba(@PathVariable Long id) {
        bombaService.excluirBomba(id);
    }

}