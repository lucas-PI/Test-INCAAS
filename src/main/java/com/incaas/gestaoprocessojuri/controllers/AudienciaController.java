package com.incaas.gestaoprocessojuri.controllers;

import com.incaas.gestaoprocessojuri.dtos.RequestPostAudiencia;
import com.incaas.gestaoprocessojuri.dtos.RequestPutAudiencia;
import com.incaas.gestaoprocessojuri.model.Audiencia;
import com.incaas.gestaoprocessojuri.services.AudienciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/audiencias")
public class AudienciaController {

    @Autowired
    private AudienciaService audienciaService;

    @GetMapping
    public ResponseEntity<List<Audiencia>> findAll(){
        List<Audiencia> audienciaList =audienciaService.findAll();
        return ResponseEntity.ok().body(audienciaList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Audiencia> findById(@PathVariable Long id){
        Audiencia audiencia = audienciaService.findById(id);
        return ResponseEntity.ok().body(audiencia);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        audienciaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Audiencia> insert(@RequestBody @Valid RequestPostAudiencia requestPostAudiencia){
        Audiencia audiencia = audienciaService.insert(requestPostAudiencia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(audiencia.getId()).toUri();
        return ResponseEntity.created(uri).body(audiencia);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Audiencia> replace(@PathVariable Long id,
                                             @RequestBody @Valid RequestPutAudiencia requestPutAudiencia){
       Audiencia obj = audienciaService.replace(id,requestPutAudiencia);
       return ResponseEntity.ok().body(obj);
    }
}
