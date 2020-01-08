package com.hackaton.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Concurso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeConcurso;
    private double notaCorte;

    @OneToMany(mappedBy = "concurso")
    private Set<CandidatoConcurso> candidatoConcursos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeConcurso() {
        return nomeConcurso;
    }

    public void setNomeConcurso(String nomeConcurso) {
        this.nomeConcurso = nomeConcurso;
    }

    public double getNotaCorte() {
        return notaCorte;
    }

    public void setNotaCorte(double notaCorte) {
        this.notaCorte = notaCorte;
    }

    public Set<CandidatoConcurso> getCandidatoConcursos() {
        return candidatoConcursos;
    }

    public void setCandidatoConcursos(Set<CandidatoConcurso> candidatoConcursos) {
        this.candidatoConcursos = candidatoConcursos;
    }
}
