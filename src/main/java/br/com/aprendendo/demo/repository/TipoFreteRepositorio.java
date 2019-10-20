package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.TipoFrete;
import br.com.aprendendo.demo.repository.query.tipofrete.TipoFreteRepositorioQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TipoFreteRepositorio extends JpaRepository<TipoFrete, Integer>, TipoFreteRepositorioQuery{    
    
}
