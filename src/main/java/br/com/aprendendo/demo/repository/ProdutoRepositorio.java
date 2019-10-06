package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, String> {

    public Page<Produto> findByReferenciaOrNomeIgnoreCaseContaining(String referencia, String nome, Pageable pageable);

    public Page<Produto> findByTipo(String tipo, Pageable pageable);
}
