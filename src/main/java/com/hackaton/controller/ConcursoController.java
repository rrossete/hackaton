package com.hackaton.controller;

import com.hackaton.dto.ConcursoDTO;
import com.hackaton.service.ConcursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/concursos")
public class ConcursoController {

    @Autowired
    private ConcursoService concursoService;

    @GetMapping
    public ResponseEntity<?> buscarConcursos(Pageable pageable){
        try{
            return ResponseEntity.ok().body(this.concursoService.buscarConcursos(pageable));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long idCandidato){
        try {
            return ResponseEntity.ok().body(this.concursoService.buscar(idCandidato));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody ConcursoDTO concursoDTO){

        try {
            this.concursoService.inserir(concursoDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editar(@RequestBody ConcursoDTO concursoDTO, @PathVariable(value = "id") Long id){
        try{
            this.concursoService.editar(concursoDTO, id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        try {
            this.concursoService.deletar(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
