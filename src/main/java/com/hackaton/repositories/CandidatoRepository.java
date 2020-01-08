package com.hackaton.repositories;

import com.hackaton.entity.Candidato;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepositoryImplementation<Candidato,Long> {
}
