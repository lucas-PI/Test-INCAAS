package com.incaas.gestaoprocessojuri.controllers;

import com.incaas.gestaoprocessojuri.model.ProcessoJudicial;
import com.incaas.gestaoprocessojuri.services.ProcessoJudicialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/processos")
public class ProcessoJudicialController {

    private ProcessoJudicialService processoJudicialService;

    @GetMapping
    public ResponseEntity<List<ProcessoJudicial>>findALl(){
        List<ProcessoJudicial> judicialList = processoJudicialService.findAll();
        return ResponseEntity.ok().body(judicialList);
    }
}
