package com.hackaton.endpoint;

import com.hackaton.service.ConcursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/concursos")
public class ConcursoEndpoint {

    @Autowired
    private ConcursoService concursoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarConcurso(@PathVariable("id") Long idCandidato){
        return ResponseEntity.ok().body(this.concursoService.buscarConcurso(idCandidato));
    }
}
