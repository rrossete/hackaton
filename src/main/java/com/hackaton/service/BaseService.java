package com.hackaton.service;

public abstract class BaseService {

    protected void lancarExcecao(boolean condicao, String mensagemValidacao){
        if(condicao){
            throw new RuntimeException(mensagemValidacao);
        }
    }
}
