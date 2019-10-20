package br.com.aprendendo.demo.repository.query;

import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.TypeSearch;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public abstract class PadraoRepositoryImpl<T> implements PadraoRepositoryQuery<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<T> filtrar(String pesquisa, Pageable pageable, Class<T> classe) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<T> criteria = builder.createQuery(classe);

        Root<T> root = criteria.from(classe);

        Predicate[] predicate = criarRestricoes(pesquisa, builder, root);

        criteria.where(predicate);

        TypedQuery<T> query = this.entityManager.createQuery(criteria);

        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, getElementSize(pesquisa, pageable, classe));
    }

    private Long getElementSize(String pesquisa, Pageable pageable, Class<T> classe) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<T> root = criteria.from(classe);
        Predicate[] predicate = criarRestricoes(pesquisa, builder, root);
        criteria.where(predicate);
        criteria.select(builder.count(root));
        TypedQuery<Long> query = this.entityManager.createQuery(criteria);
        return query.getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<T> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistroPorPagina);
    }

    public Predicate[] criarRestricoes(String pesquisa, CriteriaBuilder builder, Root<T> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isEmpty(pesquisa)) {
            return predicates.toArray(new Predicate[predicates.size()]);
        }
        Filter[] filters = getSearchNames();
        Predicate[] predicateSearch = new Predicate[filters.length];
        for (int i = 0; i < filters.length; i++) {
            Predicate predicate;
            if (TypeSearch.CONTAINING.equals(filters[i].getTypeSearch())) {
                predicate = builder.like(builder.lower(root.get(filters[i].getNameSearch())), "%" + pesquisa + "%");
                predicateSearch[i] = predicate;
                continue;
            }
            if (TypeSearch.EQUAL.equals(filters[i].getTypeSearch())) {
                predicate = builder.like(builder.lower(root.get(filters[i].getNameSearch())), pesquisa);
                predicateSearch[i] = predicate;
                continue;
            }
            if (TypeSearch.LAST.equals(filters[i].getTypeSearch())) {
                predicate = builder.like(builder.lower(root.get(filters[i].getNameSearch())), "%" + pesquisa);
                predicateSearch[i] = predicate;
                continue;
            }
            predicate = builder.like(builder.lower(root.get(filters[i].getNameSearch())), pesquisa + "%");
            predicateSearch[i] = predicate;
        }
        Predicate condicao = builder.or(predicateSearch);
        predicates.add(condicao);
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    public abstract Filter[] getSearchNames();

}