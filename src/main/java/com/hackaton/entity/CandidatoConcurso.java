package com.hackaton.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class CandidatoConcurso implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CandidatoConcursoPK candidatoConcursoId;

    @ManyToOne
    @MapsId("candidato_id")
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    @ManyToOne
    @MapsId("concurso_id")
    @JoinColumn(name = "concurso_id")
    private Concurso concurso;

    private double nota;

    public CandidatoConcurso() {
    }

    public CandidatoConcurso(CandidatoConcursoPK candidatoConcursoId, long nota) {
        this.candidatoConcursoId = candidatoConcursoId;
        this.nota = nota;
    }

    public CandidatoConcursoPK getCandidatoConcursoId() {
        return candidatoConcursoId;
    }

    public void setCandidatoConcursoId(CandidatoConcursoPK candidatoConcursoId) {
        this.candidatoConcursoId = candidatoConcursoId;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }


}
