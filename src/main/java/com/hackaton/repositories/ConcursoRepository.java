package com.hackaton.repositories;

import com.hackaton.entity.Concurso;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcursoRepository extends JpaRepositoryImplementation<Concurso, Long> {
}
