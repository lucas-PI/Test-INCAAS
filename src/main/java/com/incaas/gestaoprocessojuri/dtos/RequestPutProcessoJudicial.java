package com.incaas.gestaoprocessojuri.dtos;

import com.incaas.gestaoprocessojuri.model.enums.ProcessoJudicialStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RequestPutProcessoJudicial {

    @Pattern(regexp = "^[0-9]{7}-[0-9]{2}[.][0-9]{4}[.][0-9][.][0-9]{2}[.][0-9]{4}$")
    @NotNull
    private String numeroProcesso;
    @NotNull
    @NotEmpty
    private String vara;
    @NotNull
    @NotEmpty
    private String comarca;
    @Enumerated(EnumType.STRING)
    @NotNull
    @NotEmpty
    private ProcessoJudicialStatus status;

    public RequestPutProcessoJudicial() {
    }

    public RequestPutProcessoJudicial(String numeroProcesso, String vara,
                                      String comarca, ProcessoJudicialStatus status) {
        this.numeroProcesso = numeroProcesso;
        this.vara = vara;
        this.comarca = comarca;
        this.status = status;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public ProcessoJudicialStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessoJudicialStatus status) {
        this.status = status;
    }
}
