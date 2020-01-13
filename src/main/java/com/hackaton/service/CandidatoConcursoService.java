package com.hackaton.service;

import com.hackaton.dto.NotaDTO;
import com.hackaton.entity.CandidatoConcurso;
import com.hackaton.entity.CandidatoConcursoPK;
import com.hackaton.enums.MensagemValidacao;
import com.hackaton.repositories.CandidatoConcursoRepository;
import com.hackaton.repositories.CandidatoRepository;
import com.hackaton.repositories.ConcursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class CandidatoConcursoService {

    @Autowired
    private CandidatoConcursoRepository candidatoConcursoRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private ConcursoRepository concursoRepository;

    public void inserir(NotaDTO notaDTO){
        this.verificarSeExisteNota(notaDTO);
        this.verificarSeExisteCandidato(notaDTO.getCandidatoId());
        this.verificarSeExisteConcurso(notaDTO.getConcursoId());
        CandidatoConcurso candidatoConcurso = new CandidatoConcurso.
                                            CandidatoConcursoBuilder(notaDTO.getCandidatoId(),
                                            notaDTO.getConcursoId(), notaDTO.getNota()).build();
        this.candidatoConcursoRepository.save(candidatoConcurso);
    }

    private void verificarSeExisteCandidato(Long candidatoId) {
        this.candidatoRepository.findById(candidatoId).orElseThrow(()-> new RuntimeException(
                MessageFormat.format(MensagemValidacao.CANDIDATO_NAO_ENCONTRADO.getMensagem(), candidatoId)));
    }

    private void verificarSeExisteConcurso(Long concursoId) {
        this.concursoRepository.findById(concursoId).orElseThrow(()-> new RuntimeException(
                MessageFormat.format(MensagemValidacao.CONCURSO_NAO_ENCONTRADO.getMensagem(), concursoId)));
    }


    public void atualizar(NotaDTO notaDTO){
        CandidatoConcurso candidatoConcurso = this.candidatoConcursoRepository.findById(
                                                new CandidatoConcursoPK(notaDTO.getCandidatoId(),
                                                    notaDTO.getCandidatoId()))
                                                .orElseThrow(()-> new RuntimeException(
                                                    MensagemValidacao.NOTA_NAO_CADSASTRADA.getMensagem()));

        candidatoConcurso.setNota(notaDTO.getNota());
        this.candidatoConcursoRepository.save(candidatoConcurso);

    }

    private void verificarSeExisteNota(NotaDTO notaDTO) {

        if (this.candidatoConcursoRepository.findById(new CandidatoConcursoPK(notaDTO.getCandidatoId(),
                                                        notaDTO.getCandidatoId()))
                                                        .isPresent()){
            throw new RuntimeException(MensagemValidacao.NOTA_JA_CADASTRADA.getMensagem());
        }
    }

    public void excluir(Long idCandidato, Long idConcurso) {
        CandidatoConcursoPK pk = new CandidatoConcursoPK(idCandidato, idConcurso);
        this.candidatoConcursoRepository.findById(pk).orElseThrow(
                                        ()-> new RuntimeException(MensagemValidacao.NOTA_NAO_CADSASTRADA.getMensagem()));

        this.candidatoConcursoRepository.deleteById(pk);
    }
}
