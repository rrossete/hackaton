package com.hackaton.endpoint;

import com.hackaton.entity.Candidato;
import com.hackaton.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/candidatos")
public class CandidatoEndpoint {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarCandidato(@PathVariable("id") Long idCandidato){

        return ResponseEntity.ok().body(this.candidatoService.buscarCandidato(idCandidato));
    }
}
