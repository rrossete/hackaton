package com.hackaton.endpoint;

import com.hackaton.service.ConcursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/concurso")
public class ConcursoEndpoint {

    @Autowired
    private ConcursoService concursoService;
}
