package com.hackaton.repositories;

import com.hackaton.entity.CandidatoConcurso;
import com.hackaton.entity.CandidatoConcursoPK;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoConcursoRepository extends JpaRepositoryImplementation<CandidatoConcurso, CandidatoConcursoPK> {
}
