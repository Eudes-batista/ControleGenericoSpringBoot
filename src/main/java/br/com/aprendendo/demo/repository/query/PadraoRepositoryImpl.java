package br.com.aprendendo.demo.repository.query;

import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.SearchType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public abstract class PadraoRepositoryImpl<T> implements PadraoRepositoryQuery<T> {

    @PersistenceContext
    private EntityManager entittyManager;
    private StringBuilder sql;

    @Override
    public Page<?> filtrar(String pesquisa, Pageable pageable, Class<?> classe) {
        this.sql = null;
        this.sql = new StringBuilder();
        this.sql.append("select t from ").append(classe.getSimpleName()).append(" t where ");
        this.adicionarCondicao(pesquisa);
        TypedQuery<?> typeQuery = this.entittyManager.createQuery(this.sql.toString(), classe);
        this.adicionarRestricoesDePaginacao(typeQuery, pageable);
        return new PageImpl<>(typeQuery.getResultList(), pageable, getElementSize(pesquisa, classe));
    }

    private Long getElementSize(String pesquisa, Class<?> classe) {
        this.sql = null;
        this.sql = new StringBuilder();
        this.sql.append("select count(*) from ").append(classe.getSimpleName()).append(" where ");
        this.adicionarCondicao(pesquisa);
        TypedQuery<Long> query = this.entittyManager.createQuery(this.sql.toString(), Long.class);
        return query.getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistroPorPagina);
    }

    private void adicionarCondicao(String pesquisa) {
        Filter[] filters = getSearchNames();
        int count = 0;
        for (Filter filter : filters) {
            if (SearchType.CONTAINING.equals(filter.getSearchType())) {
                count++;
                if (count > 1) {
                    this.sql.append(" or ");
                }
                this.sql.append("upper(").append(filter.getSearchName()).append(") like '%").append(pesquisa.toUpperCase()).append("%'");
                continue;
            }
            if (SearchType.EQUAL.equals(filter.getSearchType())) {
                count++;
                if (count > 1) {
                    this.sql.append(" or ");
                }
                this.sql.append("upper(").append(filter.getSearchName()).append(") like '").append(pesquisa).append("'");
                continue;
            }
            if (SearchType.LAST.equals(filter.getSearchType())) {
                count++;
                if (count > 1) {
                    this.sql.append(" or ");
                }
                this.sql.append("upper(").append(filter.getSearchName()).append(") like '%").append(pesquisa).append("'");
                continue;
            }
            count++;
            if (count > 1) {
                this.sql.append(" or ");
            }
            this.sql.append("upper(").append(filter.getSearchName()).append(") like '").append(pesquisa).append("%'");
        }
    }

    public abstract Filter[] getSearchNames();

}
