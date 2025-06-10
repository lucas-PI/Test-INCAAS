package com.incaas.gestaoprocessojuri.services;

import com.incaas.gestaoprocessojuri.dtos.RequestPostAudiencia;
import com.incaas.gestaoprocessojuri.model.Audiencia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AudienciaServiceTest {

    @Autowired
    AudienciaService audienciaService;

    @Test
    @DisplayName("test insert onde tem como resultado sucesso")
    void insertSucesso() {
        RequestPostAudiencia requestPostAudiencia = new RequestPostAudiencia(LocalDate.of(2025,06,20), LocalTime.of(17,30),
                "Fórum Central - Sala 3","julgamento",1L);
        Audiencia obj = audienciaService.insert(requestPostAudiencia);

        assertThat(obj).isNotNull();

    }
    @Test
    @DisplayName("test insert onde as informacoes vara,local,data e hora colidem nao permitindo o save no banco e lançando uma exception")
    void insertFalha1() {
        RequestPostAudiencia requestPostAudiencia = new RequestPostAudiencia(LocalDate.of(2025,06,19), LocalTime.of(11,30),
                "Fórum Central - Sala 3","julgamento",3L);

        assertThrows(IllegalArgumentException.class,() ->{audienciaService.insert(requestPostAudiencia);});

    }
    @Test
    @DisplayName("test insert onde os status do processo jurido são supenso ou arquivado")
    void insertFalha2() {
        RequestPostAudiencia requestPostAudiencia = new RequestPostAudiencia(LocalDate.of(2025,06,20), LocalTime.of(17,30),
                "Fórum Central - Sala 3","julgamento",2L);

        assertThrows(IllegalArgumentException.class,() ->{audienciaService.insert(requestPostAudiencia);});

    }
    @Test
    @DisplayName("test insert falha pois os dias informados sao fins de semana")
    void insertFalha3() {
        RequestPostAudiencia requestPostAudiencia = new RequestPostAudiencia(LocalDate.of(2025,06,21), LocalTime.of(17,30),
                "Fórum Central - Sala 3","julgamento",1L);

        assertThrows(IllegalArgumentException.class,() ->{audienciaService.insert(requestPostAudiencia);});

    }
}