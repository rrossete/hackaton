package com.hackaton.dto;

public class NotaDTO {

    private Long candidatoId;
    private Long concursoId;
    private Double nota;

    public NotaDTO(Long candidatoId, Long concursoId, Double nota) {
        this.candidatoId = candidatoId;
        this.concursoId = concursoId;
        this.nota = nota;
    }

    public NotaDTO(){};

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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
