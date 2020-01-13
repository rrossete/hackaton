package com.hackaton.enums;

public enum MensagemValidacao {
    CANDIDATO_NAO_ENCONTRADO("Candidato, com ID: {0}, não encontrado."),
    CONCURSO_NAO_ENCONTRADO("Concurso, com ID: {0}, não encontrado."),
    CANDIDATO_NAO_SALVO("Candidato {0} não foi salvo na base de dados."),
    CANDIDATO_NAO_EXCLUIDO("Candidato com ID: {0}, não existente."),
    CANDIDATO_NAO_EDITADO("Não foi possível editar o candidato {0}"),
    ERRO_AO_BUSCAR_CANDIDATOS("Falha ao buscar candidatos"),
    CONCURSO_JA_EXISTENTE("Concurso {0} já existe."),
    NOTA_JA_CADASTRADA("Nota já foi cadastrada anteriormente."),
    NOTA_NAO_CADSASTRADA("A nota ainda não foi cadastrada."),
    NOME_CANDIDATO_OBRIGATORIO("O nome do candidato é obrigatório"),
    CPF_OBRIGATORIO("O número de CPF é obrigatório"),
    CANDIDATO_JA_CADASTRADO("Candidato com CPF: {0} já foi cadastrado anteriormente");


    private String mensagem;

    MensagemValidacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
