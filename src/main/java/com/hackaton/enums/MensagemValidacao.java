package com.hackaton.enums;

public enum MensagemValidacao {
    CANDIDATO_NAO_ENCONTRADO("Candidato, com ID: {0}, não encontrado."),
    CONCURSO_NAO_ENCONTRADO("Concurso, com ID: {0}, não encontrado."),
    CANDIDATO_NAO_SALVO("Candidato {0} não foi salvo na base de dados."),
    CANDIDATO_NAO_EXCLUIDO("Candidato com ID: {0}, não existente."),
    CANDIDATO_NAO_EDITADO("Não foi possível editar o candidato {0}"),
    ERRO_AO_BUSCAR_CANDIDATOS("Falha ao buscar candidatos"),
    CONCURSO_JA_EXISTENTE("Concurso {0} já existe.");


    private String mensagem;

    MensagemValidacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
