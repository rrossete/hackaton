package com.hackaton.controller;

import com.hackaton.dto.NotaDTO;
import com.hackaton.service.CandidatoConcursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notas")
public class CandidatoConcursoController {

    @Autowired
    private CandidatoConcursoService candidatoConcursoService;

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody NotaDTO notaDTO){
        try {
            this.candidatoConcursoService.inserir(notaDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping(value = "/{idCandidato}/{idConcurso}")
    public ResponseEntity<?> atualizar (@PathVariable(value = "idCandidato") Long idCandidato,
                                        @PathVariable(value = "idConcurso") Long idConcurso, @RequestBody Double nota){
        try {
            this.candidatoConcursoService.atualizar(new NotaDTO(idCandidato, idConcurso, nota));
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping(value = "/{idCandidato}/{idConcurso}")
    public ResponseEntity<?> excluir(@PathVariable(value = "idCandidato") Long idCandidato,
                                     @PathVariable(value = "idConcurso") Long idConcurso){
        try {
            this.candidatoConcursoService.excluir(idCandidato, idConcurso);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
