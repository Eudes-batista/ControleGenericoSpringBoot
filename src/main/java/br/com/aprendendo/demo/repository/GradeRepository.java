package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.Grade;
import br.com.aprendendo.demo.model.GradePK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GradeRepository extends JpaRepository<Grade, GradePK>{
    
    public Page<Grade> findByNomeIgnoreCaseContaining(String nome, Pageable pageable);
    
}
