package com.incaas.gestaoprocessojuri.model.enums;

public enum TipoAudiencia {
    CONCILIACAO(1,"conciliação"),
    INSTRUCAO(2,"Instrução"),
    JULGAMENTO(3,"julgamento");

    private int code;
    private String identify;

    TipoAudiencia(int code, String identify) {
        this.code = code;
        this.identify = identify;
    }

    public int getCode() {
        return code;
    }

    public String getIdentify() {
        return identify;
    }
    public static TipoAudiencia valueOf(int code){
        for(TipoAudiencia obj: values()){
            if (obj.getCode() == code){
                return obj;
            }
        }
        throw new IllegalArgumentException("invalid OrdemStatus code");
    }

    public static TipoAudiencia valueOfWithString(String identify){
        for(TipoAudiencia obj: values()){
            if (identify.equals(obj.getIdentify())){
                return obj;
            }
        }
        throw new IllegalArgumentException("invalid OrdemStatus code");
    }
}
