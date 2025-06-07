package com.incaas.gestaoprocessojuri.model.enums;

public enum ProcessoJudicialStatus {

    ATIVO(1,"ativo"),
    ARQUIVADO(2,"arquivado"),
    SUSPENSO(3,"suspenso");

    private int code;
    private String identify;

    ProcessoJudicialStatus(int code,String identify){
        this.code = code;
        this.identify = identify;
    }

    public int getCode(){return code;}
    public String getIdentify(){return identify;}

    public static ProcessoJudicialStatus valueOf(int code){
        for(ProcessoJudicialStatus obj: values()){
            if (obj.getCode() == code){
                return obj;
            }
        }
        throw new IllegalArgumentException("invalid OrdemStatus code");
    }

    public static ProcessoJudicialStatus valueOfWithString(String identify){
        for(ProcessoJudicialStatus obj: values()){
            if (identify.equals(obj.getIdentify())){
                return obj;
            }
        }
        throw new IllegalArgumentException("invalid OrdemStatus code");
    }
}
