package com.hackaton.service;

import com.hackaton.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
}
