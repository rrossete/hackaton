package com.hackaton.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Concurso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "notaCorte")
    private double notaCorte;

    @OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY)
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

    private Concurso(ConcursoBuilder concursoBuilder){
        this.id = concursoBuilder.id;
        this.nome = concursoBuilder.nome;
        this.notaCorte = concursoBuilder.notaCorte;
        this.candidatoConcursos = concursoBuilder.candidatoConcursos;
    }

    public static class ConcursoBuilder{
        private Long id;
        private String nome;
        private double notaCorte;
        private List<CandidatoConcurso> candidatoConcursos;

        public ConcursoBuilder(Long id, String nome, double notaCorte, List<CandidatoConcurso> candidatoConcursos) {
            this.id = id;
            this.nome = nome;
            this.notaCorte = notaCorte;
            this.candidatoConcursos = candidatoConcursos;
        }

        public ConcursoBuilder(String nome, double notaCorte, List<CandidatoConcurso> candidatoConcursos) {
            this.nome = nome;
            this.notaCorte = notaCorte;
            this.candidatoConcursos = candidatoConcursos;
        }

        public ConcursoBuilder(String nome, double notaCorte) {
            this.nome = nome;
            this.notaCorte = notaCorte;
        }

        public Concurso build(){
            return new Concurso(this);
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setNotaCorte(double notaCorte) {
            this.notaCorte = notaCorte;
        }

        public void setCandidatoConcursos(List<CandidatoConcurso> candidatoConcursos) {
            this.candidatoConcursos = candidatoConcursos;
        }
    }
}
