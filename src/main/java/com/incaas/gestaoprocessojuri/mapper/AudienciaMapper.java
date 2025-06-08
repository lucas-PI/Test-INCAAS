package com.incaas.gestaoprocessojuri.mapper;

import com.incaas.gestaoprocessojuri.dtos.RequestPostAudiencia;
import com.incaas.gestaoprocessojuri.dtos.RequestPutAudiencia;
import com.incaas.gestaoprocessojuri.model.Audiencia;
import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.services.ProcessoJudicialService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper(componentModel = "spring")
public abstract class AudienciaMapper {

    @Autowired
    private ProcessoJudicialService processoJudicialService;

    @Mapping(source = "processoJudicialId", target = "processoJudicial")
    public abstract Audiencia toAudiencia(RequestPostAudiencia requestPostAudiencia);
    public abstract Audiencia toAudiencia(RequestPutAudiencia requestPutAudiencia);

    protected ProcessoJudicial map(Long processoJudicialId){
        if(processoJudicialId == null) {
            throw new IllegalArgumentException("nulo");
        }
        return processoJudicialService.findById(processoJudicialId);
    }
}
