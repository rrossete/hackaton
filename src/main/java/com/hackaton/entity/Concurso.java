package com.hackaton.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Concurso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double notaCorte;

    @OneToMany(mappedBy = "concurso")
    private List<CandidatoConcurso> candidatoConcursos;

    public Concurso() {
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

    public double getNotaCorte() {
        return notaCorte;
    }

    public void setNotaCorte(double notaCorte) {
        this.notaCorte = notaCorte;
    }

    public List<CandidatoConcurso> getCandidatoConcursos() {
        return candidatoConcursos;
    }

    public void setCandidatoConcursos(List<CandidatoConcurso> candidatoConcursos) {
        this.candidatoConcursos = candidatoConcursos;
    }
}
