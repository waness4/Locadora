package com.projetoLocadora.locadora.controller;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLocadora.locadora.model.Diretor;
import com.projetoLocadora.locadora.service.DiretorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/diretor")
public class DiretorController {
    
    @Autowired
    private DiretorService service;

    @PostMapping("/criar")
    public Diretor salvarDiretor(@RequestBody Diretor novoDiretor) {
        return service.saveAll(novoDiretor);
    }
    
    @GetMapping("/listar")
    public Iterable<Diretor> obterIdDiretor() throws RelationNotFoundException{
        return service.listAll();
    }
    
    @GetMapping("/listar/{id}")
    public Diretor obterIdDiretor(@PathVariable UUID id) throws RelationNotFoundException{
        return service.listId(id);
    }

    @PutMapping("/editar/{id}")
    public Diretor editarDiretor(@PathVariable UUID id, @RequestBody Diretor diretor) throws RelationNotFoundException{
        return service.editId(diretor, id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarDiretor(@PathVariable UUID id){
        try{
            service.deleteId(id);
            return ResponseEntity.ok("Diretor deletado");
        }catch(RelationNotFoundException erro){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: " + erro.getMessage());
        }
    }
}
