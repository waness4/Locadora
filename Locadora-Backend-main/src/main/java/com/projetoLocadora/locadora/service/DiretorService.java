package com.projetoLocadora.locadora.service;

import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoLocadora.locadora.model.Diretor;
import com.projetoLocadora.locadora.repository.DiretorRepository;

@Service
public class DiretorService {
    
    @Autowired
    private DiretorRepository repository;

    public Diretor saveAll(Diretor diretor){
        repository.save(diretor);
        return diretor;
    }

    public Iterable<Diretor> listAll(){
        return repository.findAll();
    }

    public Diretor listId (UUID id) throws RelationNotFoundException{
        return repository.findById(id).orElseThrow(() -> new RelationNotFoundException("Não existe diretor com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException{
        Diretor deletada = repository.findById(id).orElseThrow(() -> new RelationNotFoundException("Não existe diretor com ID: " + id));
        
        repository.delete(deletada);
    }

    public Diretor editId(Diretor diretor, UUID id) throws RelationNotFoundException{
        Diretor alterado = repository.findById(id).orElseThrow(() -> new RelationNotFoundException("Não existe diretor com ID: " + id));

        alterado.setNome(diretor.getNome());

        return repository.save(alterado);
    }
}

