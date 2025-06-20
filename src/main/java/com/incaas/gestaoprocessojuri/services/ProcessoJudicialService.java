package com.incaas.gestaoprocessojuri.services;

import com.incaas.gestaoprocessojuri.dtos.RequestPostProcessoJudicial;
import com.incaas.gestaoprocessojuri.dtos.RequestPutProcessoJudicial;
import com.incaas.gestaoprocessojuri.mapper.ProcessoJudicialMapper;
import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.model.enums.ProcessoJudicialStatus;
import com.incaas.gestaoprocessojuri.repositories.ProcessoJudicialRepository;
import com.incaas.gestaoprocessojuri.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProcessoJudicialService {

    @Autowired
    private ProcessoJudicialRepository processoJudicialRepository;

    @Transactional(readOnly = true)
    public List<ProcessoJudicial> findAll(){
        return processoJudicialRepository.findAll();
    }
    @Transactional(readOnly = true)
    public ProcessoJudicial findById(Long id){
        ProcessoJudicial obj = processoJudicialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return obj;
    }

    @Transactional(readOnly = true)
    public List<ProcessoJudicial> findAllByComarcaIgnoreCase(String comarca){
        return processoJudicialRepository.findAllByComarcaIgnoreCase(comarca);
    }

    @Transactional
    public void delete(Long id){
        processoJudicialRepository.deleteById(id);
    }
    @Transactional
    public ProcessoJudicial insert(RequestPostProcessoJudicial objDto){
        ProcessoJudicial processoJudicial = ProcessoJudicialMapper.INSTANCE.toProcessoJudicial(objDto);
        return processoJudicialRepository.save(processoJudicial);
    }
    @Transactional
    public ProcessoJudicial replace(Long id,RequestPutProcessoJudicial objDto){
        ProcessoJudicial obj = ProcessoJudicialMapper.INSTANCE.toProcessoJudicial(objDto);
        ProcessoJudicial oldObj = findById(id);
        obj.setId(oldObj.getId());
        return processoJudicialRepository.save(obj);
    }

    @Transactional
    public List<ProcessoJudicial> findAllByStatus(String status){
        return processoJudicialRepository.findAllByStatus(ProcessoJudicialStatus.valueOf(status.toUpperCase()));
    }
    @Transactional(readOnly = true)
    public List<ProcessoJudicial> findAllByComarcaIgnoreCaseAndStatus(String comarca,String status){
        ProcessoJudicialStatus processoJudicialStatus = ProcessoJudicialStatus
                .valueOf(status.toUpperCase());
        return processoJudicialRepository.findAllByComarcaIgnoreCaseAndStatus(comarca,processoJudicialStatus);
    }
}
