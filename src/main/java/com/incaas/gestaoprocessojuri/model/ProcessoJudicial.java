package com.incaas.gestaoprocessojuri.model;

import com.incaas.gestaoprocessojuri.model.enums.ProcessoJudicialStatus;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_proce_judi")
public class ProcessoJudicial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroProcesso;
    private String vara;
    private String comarca;

    @Enumerated(EnumType.STRING)
    private ProcessoJudicialStatus status;

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
