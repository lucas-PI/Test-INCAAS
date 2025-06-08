package com.incaas.gestaoprocessojuri.repositories;

import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.model.enums.ProcessoJudicialStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoJudicialRepository extends JpaRepository<ProcessoJudicial,Long> {

    List<ProcessoJudicial> findAllByComarcaIgnoreCase(String comarca);
    List<ProcessoJudicial> findAllByStatus(ProcessoJudicialStatus Status);
    List<ProcessoJudicial> findAllByComarcaIgnoreCaseAndStatus(String comarca,ProcessoJudicialStatus Status);

}
