package com.hackaton.endpoint;

import com.hackaton.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/candidato")
public class CandidatoEndpoint {

    @Autowired
    private CandidatoService candidatoService;

}
