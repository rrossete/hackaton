package com.hackaton.repositories;

import com.hackaton.dto.CandidatoDTO;
import com.hackaton.entity.Candidato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatoRepository extends JpaRepositoryImplementation<Candidato,Long> {

    @Query(value = "Select " +
            "new com.hackaton.dto.CandidatoDTO(candidato.id, candidato.nome, candidato.cpf) " +
            "from Candidato candidato where candidato.id = :id")
    Optional<CandidatoDTO> buscarCandidato(@Param("id") Long id);

}
