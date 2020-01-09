package com.hackaton.controller;

import com.hackaton.service.ConcursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/concursos")
public class ConcursoController {

    @Autowired
    private ConcursoService concursoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarConcurso(@PathVariable("id") Long idCandidato){
        try {
            return ResponseEntity.ok().body(this.concursoService.buscarConcurso(idCandidato));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
