package com.incaas.gestaoprocessojuri.repositories;

import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoJudicialRepository extends JpaRepository<ProcessoJudicial,Long> {
}
