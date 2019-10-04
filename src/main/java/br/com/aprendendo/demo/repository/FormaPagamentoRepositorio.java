package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepositorio extends JpaRepository<FormaPagamento, Integer>{
    
}
