package com.projetoLocadora.locadora.controller;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLocadora.locadora.model.Ator;
import com.projetoLocadora.locadora.service.AtorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/ator")
public class AtorController {
    
    @Autowired
    private AtorService service;

    @PostMapping("/criar")
    public Ator salvarAtor(@RequestBody Ator novoAtor) {
        return service.saveAll(novoAtor);
    }
    
    @GetMapping("/listar")
    public Iterable<Ator> listar(){
        return service.listAll();
    }

    @GetMapping("/listar/{id}")
    public Ator obterIdAtor(@PathVariable UUID id) throws RelationNotFoundException{
        return service.listId(id);
    }
    
    @PutMapping("/editar/{id}")
    public Ator editarAtor(@PathVariable UUID id, @RequestBody Ator ator) throws RelationNotFoundException{
        return service.editId(ator, id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarAtor(@PathVariable UUID id){
        try{
            service.deleteId(id);
            return ResponseEntity.ok("Ator deletado");
        }catch(RelationNotFoundException erro){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: " + erro.getMessage());
        }
    }
}
