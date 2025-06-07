package com.incaas.gestaoprocessojuri.controllers;

import com.incaas.gestaoprocessojuri.dtos.RequestPostProcessoJudicial;
import com.incaas.gestaoprocessojuri.dtos.RequestPutProcessoJudicial;
import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.services.ProcessoJudicialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/processos")
public class ProcessoJudicialController {

    @Autowired
    private ProcessoJudicialService processoJudicialService;

    @GetMapping
    public ResponseEntity<List<ProcessoJudicial>>findALl(){
        List<ProcessoJudicial> judicialList = processoJudicialService.findAll();
        return ResponseEntity.ok().body(judicialList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProcessoJudicial>findById(@PathVariable Long id){
        ProcessoJudicial obj = processoJudicialService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        processoJudicialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProcessoJudicial> insert(@RequestBody @Valid RequestPostProcessoJudicial objDto){
        ProcessoJudicial obj = processoJudicialService.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProcessoJudicial> replace(@PathVariable Long id,
                                                    @RequestBody @Valid RequestPutProcessoJudicial objDto){
     return ResponseEntity.ok().body(processoJudicialService.replace(id, objDto));
    }
}
