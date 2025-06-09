package com.incaas.gestaoprocessojuri.repositories;

import com.incaas.gestaoprocessojuri.model.Audiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AudienciaRepository extends JpaRepository<Audiencia,Long> {

    List<Audiencia> findAllByDataAudienciaAndProcessoJudicial_Comarca(LocalDate data, String comarca);

}
