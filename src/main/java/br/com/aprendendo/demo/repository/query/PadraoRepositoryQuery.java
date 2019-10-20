package br.com.aprendendo.demo.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PadraoRepositoryQuery<T> {
    
    public Page<T> filtrar(String pesquisa,Pageable pageable,Class<T> classe);
    
}
