package com.hackaton.repositories;

import com.hackaton.dto.CandidatoDTO;
import com.hackaton.entity.Candidato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatoRepository extends PagingAndSortingRepository<Candidato,Long> {

    @Query(value = "Select " +
            "new com.hackaton.dto.CandidatoDTO(candidato.id, candidato.nome, candidato.cpf) " +
            "from Candidato candidato where candidato.id = :id")
    Optional<CandidatoDTO> buscarCandidato(@Param("id") Long id);

    @Query(value = "Select " +
            "new com.hackaton.dto.CandidatoDTO(candidato.id, candidato.nome, candidato.cpf) " +
            "from Candidato candidato")
    Page<CandidatoDTO> buscarTodosCandidatos(Pageable pageable);


    @Query(value = "select new com.hackaton.dto.CandidatoDTO(candidato.id, candidato.nome, candidato.cpf, cc.nota) " +
            "from CandidatoConcurso cc " +
            "join cc.candidato candidato where cc.candidatoConcursoId.concursoId = :id")
    List<CandidatoDTO> buscarCandidatosPorConcurso(@Param(value = "id") Long concursoId);

}
