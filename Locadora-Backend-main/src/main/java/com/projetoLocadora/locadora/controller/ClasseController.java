package com.projetoLocadora.locadora.controller;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLocadora.locadora.model.Classe;
import com.projetoLocadora.locadora.service.ClasseService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/classe")
public class ClasseController {
    
    @Autowired
    private ClasseService service;

    @PostMapping("/criar")
    public Classe salvarClasse(@RequestBody Classe novaClasse) {
        return service.saveAll(novaClasse);
    }
    
    @GetMapping("/listar")
    public Iterable<Classe> obterIdClasse() throws RelationNotFoundException{
        return service.listAll();
    }
    
    @GetMapping("/listar/{id}")
    public Classe obterIdClasse(@PathVariable UUID id) throws RelationNotFoundException{
        return service.listId(id);
    }

    @PutMapping("/editar/{id}")
    public Classe editarClasse(@PathVariable UUID id, @RequestBody Classe classe) throws RelationNotFoundException{
        return service.editId(classe, id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarClasse(@PathVariable UUID id){
        try{
            service.deleteId(id);
            return ResponseEntity.ok("Classe deletado");
        }catch(RelationNotFoundException erro){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: " + erro.getMessage());
        }
    }
}
