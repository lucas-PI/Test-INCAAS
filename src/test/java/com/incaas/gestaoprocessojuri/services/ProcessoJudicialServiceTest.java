package com.incaas.gestaoprocessojuri.services;

import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // usa H2 real, sem sobrescrever
@Transactional

class ProcessoJudicialServiceTest {


    @Autowired
    ProcessoJudicialService processoJudicialService;


    @Test
    @DisplayName("retorna dois dados cadastrado no meu banco H2")
    void findAllByComarcaIgnoreCaseSucesso() {
        List<ProcessoJudicial> processoJudicials = processoJudicialService.findAllByComarcaIgnoreCase("osasco");

        assertThat(processoJudicials).isNotNull().hasSize(2);

    }

    @Test
    @DisplayName("retorna tres dados cadastrado no meu banco H2, atributo status")
    void findAllByStatus() {
        List<ProcessoJudicial> processoJudicials = processoJudicialService.findAllByStatus("ativo");
        assertThat(processoJudicials).isNotNull().hasSize(3);

    }

    @Test
    @DisplayName("retorna dois dados cadastrado no meu banco H2, atributos comarca e status")
    void findAllByComarcaIgnoreCaseAndStatus() {
        List<ProcessoJudicial> processoJudicials = processoJudicialService.findAllByComarcaIgnoreCaseAndStatus("osasco","ativo");
        assertThat(processoJudicials).isNotNull().hasSize(2);

    }
}