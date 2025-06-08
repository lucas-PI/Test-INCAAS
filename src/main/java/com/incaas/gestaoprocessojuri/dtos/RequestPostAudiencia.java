package com.incaas.gestaoprocessojuri.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.model.enums.TipoAudiencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class RequestPostAudiencia {

    @FutureOrPresent(message = "A data da audiência deve ser hoje ou no futuro")
    private LocalDate data;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;
    private String local;
    private TipoAudiencia tipoAudiencia;
    @NotNull
    private Long processoJudicialId;

    public RequestPostAudiencia() {
    }

    public RequestPostAudiencia(LocalDate data, LocalTime hora, String local,
                                String tipoAudiencia,Long processoJudicialId) {
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.tipoAudiencia = TipoAudiencia.valueOf(tipoAudiencia.toUpperCase());
        this.processoJudicialId = processoJudicialId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public TipoAudiencia getTipoAudiencia() {
        return tipoAudiencia;
    }

    public void setTipoAudiencia(TipoAudiencia tipoAudiencia) {
        this.tipoAudiencia = tipoAudiencia;
    }

    public Long getProcessoJudicialId() {
        return processoJudicialId;
    }

    public void setProcessoJudicialId(Long processoJudicialId) {
        this.processoJudicialId = processoJudicialId;
    }
}
