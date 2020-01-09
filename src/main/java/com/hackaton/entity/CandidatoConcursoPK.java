package com.hackaton.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidatoConcursoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "candidato_id")
    private Long candidatoId;
    @Column(name = "concurso_id")
    private Long concursoId;

    public CandidatoConcursoPK() {
    }

    public Long getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(Long candidatoId) {
        this.candidatoId = candidatoId;
    }

    public Long getConcursoId() {
        return concursoId;
    }

    public void setConcursoId(Long concursoId) {
        this.concursoId = concursoId;
    }
}
