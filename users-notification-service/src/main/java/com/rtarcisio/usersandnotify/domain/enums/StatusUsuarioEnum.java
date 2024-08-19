package com.rtarcisio.usersandnotify.domain.enums;

public enum StatusUsuarioEnum {

    ATIVO("ATIVO"),
    PENDENTE("PENDENTE"),
    BLOQUEADO("BLOQUEADO"),
    DESATIVADO("DESATIVADO");


    private String descricao;



    private StatusUsuarioEnum(String descricao) {
        this.descricao = descricao;

    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}