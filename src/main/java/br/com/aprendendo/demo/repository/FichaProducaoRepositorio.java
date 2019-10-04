package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.FichaProducao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaProducaoRepositorio extends JpaRepository<FichaProducao, String>{
    
}
