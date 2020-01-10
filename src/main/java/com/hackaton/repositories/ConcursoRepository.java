package com.hackaton.repositories;

import com.hackaton.dto.ConcursoDTO;
import com.hackaton.entity.Concurso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConcursoRepository extends JpaRepositoryImplementation<Concurso, Long> {

    @Query(value = "select new com.hackaton.dto.ConcursoDTO(c.id, c.nome, c.notaCorte, cc.nota) " +
            "from CandidatoConcurso cc " +
            "join cc.concurso c where cc.candidatoConcursoId.candidatoId = :id")
    List<ConcursoDTO> buscarConcursoPorCandidato(@Param(value = "id") Long candidatoId);

    @Query(value = "select  new com.hackaton.dto.ConcursoDTO(c.id, c.nome, c.notaCorte) " +
            "from Concurso c where c.id = :id")
    Optional<ConcursoDTO> buscar(@Param(value = "id") Long id);

    Optional<Concurso> findByNome(String nome);

    @Query(value = "select  new com.hackaton.dto.ConcursoDTO(c.id, c.nome, c.notaCorte) " +
            "from Concurso c")
    Page<ConcursoDTO> buscarConcursos(Pageable pageable);
}
