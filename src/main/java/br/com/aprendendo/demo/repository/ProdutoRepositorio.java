package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, String>{
    
    @Query("select p from Produto p where p.referencia = :pesquisa or p.nome like %:pesquisa%")
    public Page<Produto> pesquisarPorReferenciaOuNome(@Param("pesquisa") String pesquisa, Pageable pageable );
    public Page<Produto> findByTipo(String tipo, Pageable pageable);
}
