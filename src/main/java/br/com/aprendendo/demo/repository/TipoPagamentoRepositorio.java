package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.TipoPagamento;
import br.com.aprendendo.demo.repository.query.tipopagamento.TipoPagamentoRepositorioQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TipoPagamentoRepositorio extends JpaRepository<TipoPagamento, Integer>, TipoPagamentoRepositorioQuery {    
    
}
