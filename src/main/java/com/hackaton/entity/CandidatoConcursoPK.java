package com.hackaton.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidatoConcursoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "candidato_id")
    private Integer candidatoId;
    @Column(name = "concurso_id")
    private Integer concursoId;

    public CandidatoConcursoPK() {
    }

    public Integer getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(Integer candidatoId) {
        this.candidatoId = candidatoId;
    }

    public Integer getConcursoId() {
        return concursoId;
    }

    public void setConcursoId(Integer concursoId) {
        this.concursoId = concursoId;
    }
}
