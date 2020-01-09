package com.hackaton.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.dto.ConcursoDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private int cpf;

    @OneToMany(mappedBy = "candidato")
    private List<CandidatoConcurso> candidatoConcursos;

    public Candidato() {
    }

    public Candidato(CandidatoBuilder candidatoBuilder) {
        this.nome = candidatoBuilder.nome;
        this.cpf = candidatoBuilder.cpf;
        this.candidatoConcursos = candidatoBuilder.candidatoConcursos;
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

    public List<CandidatoConcurso> getCandidatoConcursos() {
        return candidatoConcursos;
    }

    public void setCandidatoConcursos(List<CandidatoConcurso> candidatoConcursos) {
        this.candidatoConcursos = candidatoConcursos;
    }



    public static class CandidatoBuilder{
        private Long id;
        private String nome;
        private int cpf;
        private List<CandidatoConcurso> candidatoConcursos;

        public CandidatoBuilder() {
        }

        public CandidatoBuilder(Long id, String nome, int cpf, List<CandidatoConcurso> candidatoConcursos) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.candidatoConcursos = candidatoConcursos;
        }

        public CandidatoBuilder(String nome, int cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }

        public Candidato build(){
            return new Candidato(this);
        }
    }
}
