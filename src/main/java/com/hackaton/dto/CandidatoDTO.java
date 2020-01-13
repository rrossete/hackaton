package com.hackaton.dto;

import java.util.List;
public class CandidatoDTO {

    private Long id;
    private String nome;
    private Integer cpf;
    private double notaConcurso;
    private List<ConcursoDTO> concursos;

    public CandidatoDTO(Long id, String nome, Integer cpf, double notaConcurso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.notaConcurso = notaConcurso;
    }

    public CandidatoDTO(Long id, String nome, Integer cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public CandidatoDTO() {
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

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public List<ConcursoDTO> getConcursos() {
        return concursos;
    }

    public void setConcursos(List<ConcursoDTO> concursos) {
        this.concursos = concursos;
    }

    public double getNotaConcurso() {
        return notaConcurso;
    }

    public void setNotaConcurso(double notaConcurso) {
        this.notaConcurso = notaConcurso;
    }
}
