package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.Grade;
import br.com.aprendendo.demo.model.GradePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepositorio extends JpaRepository<Grade, GradePK>{
    
}
