package br.com.aprendendo.demo.service;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class DefaultService<T, ID> implements GenericService<T, ID> {

    private final JpaRepository<T, ID> repositorio;

    public DefaultService(JpaRepository<T, ID> repositorio) {
        this.repositorio = repositorio;
    }
    
    @Override
    public Page<T> listarTodos(Pageable pageable) {
        return this.repositorio.findAll(pageable);
    }

    @Override
    public T salvar(T t) {
        return this.repositorio.save(t);
    }

    @Override
    public T alterar(ID id, T t) {
        Optional<T> optionalT = this.repositorio.findById(id);
        if (optionalT.isEmpty()) {
            return null;
        }
        T findT = optionalT.get();
        BeanUtils.copyProperties(t, findT,this.getCamposASeremIgnoradosNaAlteracao());
        return this.repositorio.save(findT);
    }

    @Override
    public T buscar(ID id) {
        Optional<T> optionalT = this.repositorio.findById(id);
        return optionalT.isPresent() ? optionalT.get() : null;
    }    

    @Override
    public void excluir(ID id) {
        this.repositorio.deleteById(id);
    }
    
    public abstract String[] getCamposASeremIgnoradosNaAlteracao();

}
