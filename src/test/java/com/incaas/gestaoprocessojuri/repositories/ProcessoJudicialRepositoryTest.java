package com.incaas.gestaoprocessojuri.repositories;

import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.model.enums.ProcessoJudicialStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProcessoJudicialRepositoryTest {

    @Autowired
    ProcessoJudicialRepository processoJudicialRepository;

    @Test
    @DisplayName("deve encontrar todos os processos por comarca com sucesso")
    void findAllByComarcaIgnoreCaseCaso1() {
       List<ProcessoJudicial> listTest =  processoJudicialRepository.findAllByComarcaIgnoreCase("osasco");
       assertThat(listTest.isEmpty()).isFalse();
    }
    @Test
    @DisplayName("a lista deve ser vazia pois a comarca passada no argumento não existe ou não consta na base de dados")
    void findAllByComarcaIgnoreCaseCaso2() {
        List<ProcessoJudicial> listTest =  processoJudicialRepository.findAllByComarcaIgnoreCase("Porto feliz");
        assertThat(listTest.isEmpty()).isTrue();
    }
    @Test
    void findAllByStatus() {
    }

    @Test
    @DisplayName("passando com argumentos validos, deve retorna com sucesso a requisicao")
    void findAllByComarcaIgnoreCaseAndStatusCaso1() {
        List<ProcessoJudicial> listTest =  processoJudicialRepository.
                findAllByComarcaIgnoreCaseAndStatus("osasco",ProcessoJudicialStatus.ATIVO);
        assertThat(listTest.isEmpty()).isFalse();

    }
    @Test
    @DisplayName("passando com argumentos invalidos, nao deve retorna com sucesso a requisicao")
    void findAllByComarcaIgnoreCaseAndStatusCaso2() {
        List<ProcessoJudicial> listTest =  processoJudicialRepository.
                findAllByComarcaIgnoreCaseAndStatus("porto feliz",ProcessoJudicialStatus.ATIVO);
        assertThat(listTest.isEmpty()).isTrue();

    }
}