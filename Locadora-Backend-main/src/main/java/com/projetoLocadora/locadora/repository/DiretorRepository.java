package com.projetoLocadora.locadora.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoLocadora.locadora.model.Diretor;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, UUID>{
    
}