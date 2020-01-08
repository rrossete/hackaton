package com.hackaton.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
    private Set<CandidatoConcurso> candidatoConcursos;

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

    public Set<CandidatoConcurso> getCandidatoConcursos() {
        return candidatoConcursos;
    }

    public void setCandidatoConcursos(Set<CandidatoConcurso> candidatoConcursos) {
        this.candidatoConcursos = candidatoConcursos;
    }
}
