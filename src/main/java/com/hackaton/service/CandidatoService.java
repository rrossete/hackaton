package com.hackaton.service;

import com.hackaton.enums.MensagemValidacao;
import com.hackaton.entity.Candidato;
import com.hackaton.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato buscarCandidato(Long idCandidato){
      Optional<Candidato> candidato = this.candidatoRepository.findById(idCandidato);
        return candidato.orElseThrow(()-> new RuntimeException(
                MessageFormat.format(MensagemValidacao.CANDIDATO_NAO_ENCONTRADO.getMensagem(), idCandidato)));

    }
}
