package com.hackaton.service;

import com.hackaton.repositories.CandidatoConcursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoConcursoService {

    @Autowired
    private CandidatoConcursoRepository candidatoConcursoRepository;
}
