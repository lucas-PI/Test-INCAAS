package com.incaas.gestaoprocessojuri.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.model.enums.TipoAudiencia;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.time.LocalTime;

public class RequestPutAudiencia {

    @FutureOrPresent(message = "A data da audiência deve ser hoje ou no futuro")
    private LocalDate data;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;
    private String local;
    @Enumerated(EnumType.STRING)
    private TipoAudiencia tipoAudiencia;

    public RequestPutAudiencia() {
    }

    public RequestPutAudiencia(LocalDate data, LocalTime hora, String local,
                               TipoAudiencia tipoAudiencia) {
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.tipoAudiencia = tipoAudiencia;
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
    }
