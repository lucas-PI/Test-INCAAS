package com.incaas.gestaoprocessojuri.services;

import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.repositories.ProcessoJudicialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoJudicialService {

    @Autowired
    private ProcessoJudicialRepository processoJudicialRepository;

    public List<ProcessoJudicial> findAll(){
        return processoJudicialRepository.findAll();
    }

    public ProcessoJudicial findById(Long id){
        ProcessoJudicial obj = processoJudicialRepository.findById(id).get();
        return obj;
    }

    public void delete(Long id){
        processoJudicialRepository.deleteById(id);
    }
}
