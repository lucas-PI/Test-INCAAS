package com.incaas.gestaoprocessojuri.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.incaas.gestaoprocessojuri.model.enums.ProcessoJudicialStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_proce_judi")
public class ProcessoJudicial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_processo", nullable = false, unique = true)
    @Pattern(regexp = "^[0-9]{7}-[0-9]{2}[.][0-9]{4}[.][0-9][.][0-9]{2}[.][0-9]{4}$")
    private String numeroProcesso;
    private String vara;
    private String comarca;
    @Enumerated(EnumType.STRING)
    private ProcessoJudicialStatus status;
    @JsonIgnore
    @OneToMany(mappedBy = "processoJudicial")
    private List<Audiencia> audiencias = new ArrayList<>();

    public ProcessoJudicial() {
    }

    public ProcessoJudicial(Long id, String numeroProcesso, String vara,
                            String comarca, ProcessoJudicialStatus status) {
        this.id = id;
        this.numeroProcesso = numeroProcesso;
        this.vara = vara;
        this.comarca = comarca;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Audiencia> getAudiencias() {
        return audiencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessoJudicial that = (ProcessoJudicial) o;
        return Objects.equals(id, that.id) && Objects.equals(numeroProcesso, that.numeroProcesso) && Objects.equals(comarca, that.comarca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroProcesso, comarca);
    }
}
