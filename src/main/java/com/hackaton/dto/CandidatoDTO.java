package com.hackaton.dto;

import java.util.List;
public class CandidatoDTO {

    private Long id;
    private String nome;
    private int cpf;
    private List<ConcursoDTO> concursos;

    public CandidatoDTO(Long id, String nome, int cpf) {
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public List<ConcursoDTO> getConcursos() {
        return concursos;
    }

    public void setConcursos(List<ConcursoDTO> concursos) {
        this.concursos = concursos;
    }

}
