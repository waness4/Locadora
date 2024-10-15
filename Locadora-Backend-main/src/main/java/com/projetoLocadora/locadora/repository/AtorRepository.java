package com.projetoLocadora.locadora.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoLocadora.locadora.model.Ator;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<Ator, UUID>{

}
