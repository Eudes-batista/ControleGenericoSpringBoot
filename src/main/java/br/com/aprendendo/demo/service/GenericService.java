package br.com.aprendendo.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T,ID> {

    public Page<T> listarTodos(Pageable pageable);
    public Page<?> pesquisarConteudo(String pesquisa, Pageable pageable);
    public T buscar(ID id);
    public T salvar(T t);
    public T alterar(ID id,T t);
    public void excluir(ID id);
    
}
