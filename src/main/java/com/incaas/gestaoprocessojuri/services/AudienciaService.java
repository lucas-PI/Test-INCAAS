package com.incaas.gestaoprocessojuri.services;

import com.incaas.gestaoprocessojuri.dtos.RequestPostAudiencia;
import com.incaas.gestaoprocessojuri.dtos.RequestPutAudiencia;
import com.incaas.gestaoprocessojuri.mapper.AudienciaMapper;
import com.incaas.gestaoprocessojuri.model.Audiencia;
import com.incaas.gestaoprocessojuri.model.enums.ProcessoJudicialStatus;
import com.incaas.gestaoprocessojuri.repositories.AudienciaRepository;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
        List<Audiencia> AudienciaList = audienciaRepository.findAll();
        Audiencia audienciaObj = audienciaMapper.toAudiencia(requestPostAudiencia);

        for (Audiencia obj: AudienciaList){

            boolean locaIgual = audienciaObj.getLocal().equals(obj.getLocal());
            boolean varaIgual = audienciaObj.getProcessoJudicial().getVara().equals(obj.getProcessoJudicial().getVara());
            boolean dataAudienciaIgual = audienciaObj.getDataAudiencia().equals(obj.getDataAudiencia());
            boolean horaIgual = audienciaObj.getHora().equals(obj.getHora());

            if( locaIgual && varaIgual && dataAudienciaIgual && horaIgual){
                System.out.println("entrou no erro");
                throw new IllegalArgumentException("Vara e local já ocupados neste dia e horário.");
            }
        }

        boolean statusIgualArquivado = audienciaObj.getProcessoJudicial().getStatus().equals(ProcessoJudicialStatus.ARQUIVADO);
        boolean statusIgualSuspenso = audienciaObj.getProcessoJudicial().getStatus().equals(ProcessoJudicialStatus.SUSPENSO);

        if( statusIgualArquivado|| statusIgualSuspenso) {
            System.out.println("status invalido!!!!");
            throw new IllegalArgumentException("o processo não pode está arquivado ou suspenso");
        }

        boolean diaIgualASabado = audienciaObj.getDataAudiencia().getDayOfWeek().getValue() == 6 ;
        boolean diaIgualADomingo = audienciaObj.getDataAudiencia().getDayOfWeek().getValue() == 7;
        if ( diaIgualASabado||diaIgualADomingo) {
            System.out.println("sabado ou domingo");
            throw new IllegalArgumentException("o dia não pode ser marcado em fins de semana");
        }

        return audienciaRepository.save(audienciaMapper.toAudiencia(requestPostAudiencia));
    }

    @Transactional
    public Audiencia replace(Long id,RequestPutAudiencia requestPutAudiencia){
        Audiencia audienciaObj = audienciaMapper.toAudiencia(requestPutAudiencia);

        boolean diaIgualASabado = audienciaObj.getDataAudiencia().getDayOfWeek().getValue() == 6 ;
        boolean diaIgualADomingo = audienciaObj.getDataAudiencia().getDayOfWeek().getValue() == 7;
        if ( diaIgualASabado||diaIgualADomingo) {
            System.out.println("sabado ou domingo");
            throw new IllegalArgumentException("o dia não pode ser marcado em fins de semana");
        }
        Audiencia newObj = audienciaMapper.toAudiencia(requestPutAudiencia);
        Audiencia oldObj = findById(id);
        newObj.setId(oldObj.getId());
        return audienciaRepository.save(newObj);
    }
    @Transactional
    public List<Audiencia> findAllByDataAudienciaAndByProcessoJudicialComarca(LocalDate data, String comarca){
        @FutureOrPresent
        LocalDate dataAudiencia = data;
       return audienciaRepository.findAllByDataAudienciaAndProcessoJudicial_Comarca(data,comarca);
    }
}
