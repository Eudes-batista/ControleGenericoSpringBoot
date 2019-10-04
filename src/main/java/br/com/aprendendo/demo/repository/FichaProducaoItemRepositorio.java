package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.FichaProdutoItem;
import br.com.aprendendo.demo.model.FichaProdutoItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaProducaoItemRepositorio extends JpaRepository<FichaProdutoItem, FichaProdutoItemPK>{
    
}
