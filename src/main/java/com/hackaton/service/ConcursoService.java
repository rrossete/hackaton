package com.hackaton.service;

import com.hackaton.dto.ConcursoDTO;
import com.hackaton.entity.Concurso;
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
public class ConcursoService extends BaseService{

    @Autowired
    private ConcursoRepository concursoRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    public ConcursoDTO buscar(Long idConcurso){
        ConcursoDTO concursoDTO =  this.concursoRepository.buscar(idConcurso).orElseThrow(()-> new RuntimeException());//passar mensagem de erro
        concursoDTO.setCandidatos(this.candidatoRepository.buscarCandidatosPorConcurso(concursoDTO.getId()));
        return concursoDTO;
    }

    public void editar(ConcursoDTO concursoDTO, Long id){
        Concurso concurso = atualizarConcurso(concursoDTO, id);
        this.concursoRepository.save(concurso);
    }

    private Concurso atualizarConcurso(ConcursoDTO concursoDTO, Long id) {
        Concurso concurso = this.concursoRepository.findById(id).orElseThrow(()-> new RuntimeException(
                MessageFormat.format(MensagemValidacao.CONCURSO_NAO_ENCONTRADO.getMensagem(), id)
        ));
        if(Objects.nonNull(concurso.getNome())){
            concurso.setNome(concursoDTO.getNome());
        }
        if(Objects.nonNull(concursoDTO.getNotaCorte())){
            concurso.setNotaCorte(concursoDTO.getNotaCorte());
        }
        return concurso;
    }


    public void inserir(ConcursoDTO concursoDTO) {
        this.validarConcursoExistente(concursoDTO.getNome());

        Concurso concurso = new Concurso.ConcursoBuilder(concursoDTO.getNome(), concursoDTO.getNotaCorte()).build();

        this.concursoRepository.save(concurso);
    }

    private void validarConcursoExistente(String nome) {
        if(this.concursoRepository.findByNome(nome).isPresent()){
            throw new RuntimeException(MessageFormat.format(MensagemValidacao.CONCURSO_JA_EXISTENTE.getMensagem(), nome));
        }
    }

    public Page<ConcursoDTO> buscarConcursos(Pageable pageable) {
        return this.concursoRepository.buscarConcursos(pageable);
    }

    public void deletar(Long id) {
        this.validarConcursoExistente(id);
        this.concursoRepository.deleteById(id);
    }

    private void validarConcursoExistente(Long id) {
        if(this.concursoRepository.findById(id).isEmpty()){
            throw new RuntimeException( MessageFormat.format(MensagemValidacao.CONCURSO_NAO_ENCONTRADO.getMensagem(), id));
        }
    }
}
