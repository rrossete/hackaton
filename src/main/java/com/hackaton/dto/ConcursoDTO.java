package com.hackaton.dto;

import java.util.List;


public class ConcursoDTO {

    private Long id;
    private String nome;
    private Double notaCorte;
    private double notaCandidato;
    private List<CandidatoDTO> candidatos;

    public ConcursoDTO() {
    }

    public ConcursoDTO(Long id, String nome, double notaCorte, Double notaCandidato) {
        this.id = id;
        this.nome = nome;
        this.notaCorte = notaCorte;
        this.notaCandidato = notaCandidato;
    }

    public ConcursoDTO(Long id, String nome, Double notaCorte) {
        this.id = id;
        this.nome = nome;
        this.notaCorte = notaCorte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNotaCorte() {
        return notaCorte;
    }

    public void setNotaCorte(Double notaCorte) {
        this.notaCorte = notaCorte;
    }

    public List<CandidatoDTO> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<CandidatoDTO> candidatos) {
        this.candidatos = candidatos;
    }

    public double getNotaCandidato() {
        return notaCandidato;
    }

    public void setNotaCandidato(double notaCandidato) {
        this.notaCandidato = notaCandidato;
    }
}
