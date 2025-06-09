package com.incaas.gestaoprocessojuri.model.enums;

public enum TipoAudiencia {
    CONCILIACAO(1),
    INSTRUCAO(2),
    JULGAMENTO(3);

    private int code;

    TipoAudiencia(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoAudiencia valueOf(int code){
        for(TipoAudiencia obj: values()){
            if (obj.getCode() == code){
                return obj;
            }
        }
        throw new IllegalArgumentException("invalid OrdemStatus code");
    }


}
