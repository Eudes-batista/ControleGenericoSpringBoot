package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.TipoPagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TipoPagamentoRepositorio extends JpaRepository<TipoPagamento, Integer>{
    
    public Page<TipoPagamento> findByNomeIgnoreCaseContaining(String nome, Pageable pageable);
    
}
