package br.com.aprendendo.demo.repository.query;

import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.SearchType;
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
    public Page<?> filtrar(String pesquisa, Pageable pageable, Class<?> classe) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<?> criteria = builder.createQuery(classe);

        Root<?> root = criteria.from(classe);

        Predicate[] predicate = criarRestricoes(pesquisa, builder, root);

        criteria.where(predicate);

        TypedQuery<?> query = this.entityManager.createQuery(criteria);

        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, getElementSize(pesquisa, pageable, classe));
    }

    private Long getElementSize(String pesquisa, Pageable pageable, Class<?> classe) {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<?> root = criteria.from(classe);
        Predicate[] predicate = criarRestricoes(pesquisa, builder, root);
        criteria.where(predicate);
        criteria.select(builder.count(root));
        TypedQuery<Long> query = this.entityManager.createQuery(criteria);
        return query.getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistroPorPagina);
    }

    public Predicate[] criarRestricoes(String pesquisa, CriteriaBuilder builder, Root<?> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isEmpty(pesquisa)) {
            return predicates.toArray(new Predicate[predicates.size()]);
        }
        Filter[] filters = getSearchNames();
        Predicate[] predicateSearch = new Predicate[filters.length];
        for (int i = 0; i < filters.length; i++) {
            Predicate predicate;
            if (SearchType.CONTAINING.equals(filters[i].getSearchType())) {
                predicate = builder.like(builder.lower(root.get(filters[i].getSearchName())), "%" + pesquisa + "%");
                predicateSearch[i] = predicate;
                continue;
            }
            if (SearchType.EQUAL.equals(filters[i].getSearchType())) {
                predicate = builder.like(builder.lower(root.get(filters[i].getSearchName())), pesquisa);
                predicateSearch[i] = predicate;
                continue;
            }
            if (SearchType.LAST.equals(filters[i].getSearchType())) {
                predicate = builder.like(builder.lower(root.get(filters[i].getSearchName())), "%" + pesquisa);
                predicateSearch[i] = predicate;
                continue;
            }
            predicate = builder.like(builder.lower(root.get(filters[i].getSearchName())), pesquisa + "%");
            predicateSearch[i] = predicate;
        }
        Predicate condicao = builder.or(predicateSearch);
        predicates.add(condicao);
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    public abstract Filter[] getSearchNames();

}
