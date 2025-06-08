package com.incaas.gestaoprocessojuri.repositories;

import com.incaas.gestaoprocessojuri.model.Audiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienciaRepository extends JpaRepository<Audiencia,Long> {
}
