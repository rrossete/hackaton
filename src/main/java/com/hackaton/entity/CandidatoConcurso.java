package com.hackaton.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    public CandidatoConcurso(CandidatoConcursoBuilder candidatoConcursoBuilder) {
        this.candidatoConcursoId = new CandidatoConcursoPK(candidatoConcursoBuilder.candidatoId,
                                                            candidatoConcursoBuilder.concursoId);

        this.nota = candidatoConcursoBuilder.nota;
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

    public static class CandidatoConcursoBuilder{

        private Long candidatoId;
        private Long concursoId;
        private Double nota;

        public CandidatoConcursoBuilder(Long candidatoId, Long concursoId, Double nota){
            this.candidatoId = candidatoId;
            this.concursoId = concursoId;
            this.nota = nota;
        }

        public CandidatoConcurso build (){
            return new CandidatoConcurso(this);
        }

    }

}
