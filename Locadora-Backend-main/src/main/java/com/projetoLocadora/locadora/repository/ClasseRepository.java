package com.projetoLocadora.locadora.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoLocadora.locadora.model.Classe;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, UUID> {
    
}
