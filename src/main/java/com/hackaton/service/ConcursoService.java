package com.hackaton.service;

import com.hackaton.entity.Candidato;
import com.hackaton.entity.Concurso;
import com.hackaton.enums.MensagemValidacao;
import com.hackaton.repositories.ConcursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class ConcursoService {

    @Autowired
    private ConcursoRepository concursoRepository;

    public Concurso buscarConcurso(Long idConcurso){
        Optional<Concurso> candidato = this.concursoRepository.findById(idConcurso);
        return candidato.orElseThrow(()-> new RuntimeException(
                MessageFormat.format(MensagemValidacao.CONCURSO_NAO_ENCONTRADO.getMensagem(), idConcurso)));
    }
}
