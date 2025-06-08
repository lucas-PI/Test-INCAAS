package com.incaas.gestaoprocessojuri.services;

import com.incaas.gestaoprocessojuri.dtos.RequestPostAudiencia;
import com.incaas.gestaoprocessojuri.dtos.RequestPutAudiencia;
import com.incaas.gestaoprocessojuri.mapper.AudienciaMapper;
import com.incaas.gestaoprocessojuri.model.Audiencia;
import com.incaas.gestaoprocessojuri.repositories.AudienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AudienciaService {

    @Autowired
    private AudienciaRepository audienciaRepository;
    @Autowired
    private AudienciaMapper audienciaMapper;

    @Transactional(readOnly = true)
    public List<Audiencia> findAll(){
        return audienciaRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Audiencia findById(Long id){
        Optional<Audiencia> obj = audienciaRepository.findById(id);
        return obj.get();
    }
    @Transactional
    public void delete(Long id){
        audienciaRepository.deleteById(id);
    }
    @Transactional
    public Audiencia insert(RequestPostAudiencia requestPostAudiencia){
        return audienciaRepository.save(audienciaMapper.toAudiencia(requestPostAudiencia));
    }
    @Transactional
    public Audiencia replace(Long id,RequestPutAudiencia requestPutAudiencia){
        Audiencia newObj = audienciaMapper.toAudiencia(requestPutAudiencia);
        Audiencia oldObj = findById(id);
        newObj.setId(oldObj.getId());
        return audienciaRepository.save(newObj);
    }
}
