package com.hackaton.controller;

import com.hackaton.dto.CandidatoDTO;
import com.hackaton.enums.MensagemValidacao;
import com.hackaton.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping(value = "/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarCandidato(@PathVariable("id") Long idCandidato){
       try{
           return ResponseEntity.ok().body(this.candidatoService.buscarCandidato(idCandidato));
       }catch (Exception e){
           return ResponseEntity.badRequest().body(
                   MessageFormat.format(MensagemValidacao.CANDIDATO_NAO_ENCONTRADO.getMensagem(),
                   idCandidato));
       }

    }

    @PostMapping
    public ResponseEntity<?> inserirCandidato(@RequestBody CandidatoDTO candidatoDTO){
       try{
           this.candidatoService.inserirCandidato(candidatoDTO);
           return ResponseEntity.ok().build();
       }catch (Exception e){
           return ResponseEntity.badRequest().body(
                   MessageFormat.format(MensagemValidacao.CANDIDATO_NAO_SALVO.getMensagem(),
                   candidatoDTO.getNome()));
       }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> excluirCandidato(@PathVariable("id") Long idCandidato){
        try{
            this.candidatoService.excluirCandidato(idCandidato);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(MessageFormat.format(
                    MensagemValidacao.CANDIDATO_NAO_EXCLUIDO.getMensagem(),
                    idCandidato));
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editarCandidato(@RequestBody CandidatoDTO candidatoDTO,@PathVariable("id") Long idCandidato){
        try{
            this.candidatoService.editarCandidato(candidatoDTO,idCandidato );
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(MessageFormat.format(
                    MensagemValidacao.CANDIDATO_NAO_EDITADO.getMensagem(),
                    candidatoDTO.getNome()));
        }
    }
}
