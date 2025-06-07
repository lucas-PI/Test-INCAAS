package com.incaas.gestaoprocessojuri.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.incaas.gestaoprocessojuri.model.enums.TipoAudiencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_audiencia")
public class Audiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FutureOrPresent(message = "A data da audiência deve ser hoje ou no futuro")
    @Column(name = "data_audiencia")
    private LocalDate data;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;
    private String local;
    @Enumerated(EnumType.STRING)
    private TipoAudiencia tipoAudiencia;
    @ManyToOne
    @JoinColumn(name = "processo_judi_id")
    private ProcessoJudicial processoJudicial;

    public Audiencia() {
    }

    public Audiencia(LocalDate data, LocalTime hora, String local, TipoAudiencia tipoAudiencia, ProcessoJudicial processoJudicial) {
        this.data = data;
        this.hora = hora.withSecond(0).withNano(0);;
        this.local = local;
        this.tipoAudiencia = tipoAudiencia;
        this.processoJudicial = processoJudicial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProcessoJudicial getProcessoJudicial() {
        return processoJudicial;
    }

    public void setProcessoJudicial(ProcessoJudicial processoJudicial) {
        this.processoJudicial = processoJudicial;
    }
    @PrePersist
    @PreUpdate
    public void normalizarHora() {
        if (this.hora != null) {
            this.hora = this.hora.withSecond(0).withNano(0);
        }
    }
}
