package com.hackaton.enums;

public enum MensagemValidacao {
    CANDIDATO_NAO_ENCONTRADO("Candidato, com ID: {0}, não encontrado."),
    CONCURSO_NAO_ENCONTRADO("Concurso, com ID: {0}, não encontrado.");

    private String mensagem;

    MensagemValidacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
