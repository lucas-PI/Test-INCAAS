package com.incaas.gestaoprocessojuri.mapper;

import com.incaas.gestaoprocessojuri.dtos.RequestPostProcessoJudicial;
import com.incaas.gestaoprocessojuri.dtos.RequestPutProcessoJudicial;
import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProcessoJudicialMapper {
    public static final ProcessoJudicialMapper INSTANCE = Mappers.getMapper(ProcessoJudicialMapper.class);

    public abstract ProcessoJudicial toProcessoJudicial(RequestPostProcessoJudicial requestPostProcessoJudicial);
    public abstract ProcessoJudicial toProcessoJudicial(RequestPutProcessoJudicial requestPutProcessoJudicial);
}
