package com.hackaton.service;

import com.hackaton.repositories.ConcursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcursoService {

    @Autowired
    private ConcursoRepository concursoRepository;
}
