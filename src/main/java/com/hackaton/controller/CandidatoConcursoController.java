package com.hackaton.controller;

import com.hackaton.service.CandidatoConcursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nota")
public class CandidatoConcursoController {

    @Autowired
    private CandidatoConcursoService candidatoConcursoService;
}
