package com.hackaton.service;

import com.hackaton.dto.CandidatoDTO;
import com.hackaton.entity.Candidato;
import com.hackaton.enums.MensagemValidacao;
import com.hackaton.repositories.CandidatoRepository;
import com.hackaton.repositories.ConcursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Objects;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private ConcursoRepository concursoRepository;

    public CandidatoDTO buscarCandidato(Long idCandidato){
        CandidatoDTO candidato = this.candidatoRepository.buscarCandidato(idCandidato).orElseThrow(()-> new RuntimeException());
        candidato.setConcursos(this.concursoRepository.buscarConcursoPorCandidato(idCandidato));
        return candidato;
    }

    public void inserirCandidato(CandidatoDTO candidatoDTO){
        this.validarCampos(candidatoDTO);
        verificarSeCandidatoCadastrado(candidatoDTO.getCpf());
        Candidato candidato = new Candidato.CandidatoBuilder(candidatoDTO.getNome(), candidatoDTO.getCpf()).build();
        this.candidatoRepository.save(candidato);
    }

    private void verificarSeCandidatoCadastrado(Integer cpf) {
        if(this.candidatoRepository.findByCpf(cpf).isPresent()){
            throw new RuntimeException(MessageFormat.format(MensagemValidacao.CANDIDATO_JA_CADASTRADO.getMensagem(),
                    cpf));
        }
    }

    private void validarCampos(CandidatoDTO candidatoDTO) {
        this.lancarExcecao( Objects.isNull(candidatoDTO.getNome()),
                MensagemValidacao.NOME_CANDIDATO_OBRIGATORIO.getMensagem());
        this.lancarExcecao( Objects.isNull(candidatoDTO.getCpf()),
                MensagemValidacao.CPF_OBRIGATORIO.getMensagem() );

    }

    public void lancarExcecao(Boolean lancarExcecao, String mensagemValidacao){
        if(lancarExcecao){
            throw new RuntimeException(mensagemValidacao);
        }
    }


    public void excluirCandidato(Long idCandidato) {
        this.candidatoRepository.deleteById(idCandidato);
    }

    public void editarCandidato(CandidatoDTO candidatoDTO, Long idCandidato) {
        this.validarCampos(candidatoDTO);
        this.verificarSeCandidatoCadastrado(candidatoDTO.getCpf());
        Candidato candidato = atualizarCandidato(candidatoDTO, idCandidato);
        this.candidatoRepository.save(candidato);
    }

    public Page<CandidatoDTO> buscarTodosCandidatos(Pageable pageable){
        return this.candidatoRepository.buscarTodosCandidatos(pageable);
    }

    private Candidato atualizarCandidato(CandidatoDTO candidatoDTO, Long idCandidato) {
        Candidato candidato = buscarCandidatoParaAtualizar(idCandidato);
        candidato.setCpf(candidatoDTO.getCpf());
        candidato.setNome(candidatoDTO.getNome());
        return candidato;
    }

    private Candidato buscarCandidatoParaAtualizar(Long idCandidato) {
        return this.candidatoRepository.findById(idCandidato).orElseThrow(()-> new RuntimeException());
    }
}
