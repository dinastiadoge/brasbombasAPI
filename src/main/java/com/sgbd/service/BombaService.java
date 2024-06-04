package com.sgbd.service;


import com.sgbd.Exceptions.BombaExistenteException;
import com.sgbd.Exceptions.ProdutoExistenteException;
import com.sgbd.entity.Bomba;
import com.sgbd.repository.BombaRepository;
import com.sgbd.request.AtualizarBombaRequest;
import com.sgbd.request.CadastrarBombaRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BombaService {

    @Autowired
    private BombaRepository bombaRepository;

    public Bomba salvarBomba(CadastrarBombaRequest request) {


        Optional<Bomba> bombaValidacao = bombaRepository.findById(request.getOS());
        if (bombaValidacao.isPresent()) {
            throw new BombaExistenteException("Já existe essa bomba no banco de dados");
        }

        Bomba bomba = Bomba.builder()
                .OS(request.getOS())
                .marca(request.getMarca())
                .modelo(request.getModelo())
                .potencia(request.getPotencia())
                .voltagem(request.getVoltagem())
                .descricao(request.getDescricao())
                .build();

        return this.bombaRepository.save(bomba);

    }


    public List<Bomba> obterBombas() {
        return this.bombaRepository.findAll();
    }

    public Optional<Bomba> obterBomba(Long id) {
        return this.bombaRepository.findById(id);
    }

    public void excluirBomba(Long bomba_id) {
        this.bombaRepository.deleteById(bomba_id);
    }

    public Bomba atualizarBomba(Long id, AtualizarBombaRequest request) {
        Bomba bomba = this.bombaRepository.findById(id).get();
        bomba.setMarca(request.getMarca());
        bomba.setModelo(request.getModelo());
        bomba.setVoltagem(request.getVoltagem());
        bomba.setPotencia(request.getPotencia());
        bomba.setDescricao(request.getDescricao());
        this.bombaRepository.save(bomba);
        return bomba;
    }
}
