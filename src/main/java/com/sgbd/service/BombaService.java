package com.sgbd.service;


import com.sgbd.Exceptions.BombaExistenteException;
import com.sgbd.Exceptions.ClienteInexistenteException;
import com.sgbd.Exceptions.NaoPermitirAlterarStatusException;
import com.sgbd.entity.Bomba;
import com.sgbd.entity.Cliente;
import com.sgbd.repository.BombaRepository;
import com.sgbd.repository.ClienteRepository;
import com.sgbd.request.AtualizarBombaRequest;
import com.sgbd.request.CadastrarBombaRequest;
import com.sgbd.status.StatusEnum;
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
    @Autowired
    private ClienteRepository clienteRepository;

    public Bomba salvarBomba(CadastrarBombaRequest request) {


        Optional<Bomba> bombaValidacao = bombaRepository.findById(request.getOS());
        if (bombaValidacao.isPresent()) {
            throw new BombaExistenteException("Já existe essa bomba no banco de dados");
        }
        Optional<Cliente> clienteValidacao = clienteRepository.findById(Long.valueOf(request.getCliente_cpf()));
        if (clienteValidacao.isEmpty()) {
            throw new ClienteInexistenteException("Cadastre o proprietário da bomba antes!");
        }

        //validacao de status
        if (request.getStatus().equals(StatusEnum.FINALIZADA)
                || request.getStatus().equals(StatusEnum.ESPERA)
                || request.getStatus().equals(StatusEnum.AUTORIZADA)
                || request.getStatus().equals(StatusEnum.NAO_AUTORIZADA)
                || request.getStatus().equals(StatusEnum.ENTREGUE)) {
            throw new NaoPermitirAlterarStatusException("Não é permitido cadastrar uma bomba com o status:" + request.getStatus());
        }

        Bomba bomba = Bomba.builder()
                .OS(request.getOS())
                .marca(request.getMarca())
                .modelo(request.getModelo())
                .potencia(request.getPotencia())
                .voltagem(request.getVoltagem())
                .descricao(request.getDescricao())
                .cliente(request.getCliente_cpf())
                .status(request.getStatus())
                .valor(request.getValor())
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

        if (request.getStatus().equals(StatusEnum.ORCAMENTO) && bomba.getStatus().equals(StatusEnum.ENTREGUE)
                || request.getStatus().equals(StatusEnum.NAO_AUTORIZADA) && bomba.getStatus().equals(StatusEnum.FINALIZADA)) {
            throw new NaoPermitirAlterarStatusException(
                    "Não é permitido mover o status de uma bomba de: ORÇAMENTO para o status: ENTREGUE");
        }

        bomba.setMarca(request.getMarca());
        bomba.setModelo(request.getModelo());
        bomba.setVoltagem(request.getVoltagem());
        bomba.setPotencia(request.getPotencia());
        bomba.setDescricao(request.getDescricao());
        this.bombaRepository.save(bomba);
        return bomba;
    }
}
