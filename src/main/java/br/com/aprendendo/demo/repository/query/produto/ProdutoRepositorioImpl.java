package br.com.aprendendo.demo.repository.query.produto;

import br.com.aprendendo.demo.model.Produto;
import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.TypeSearch;
import br.com.aprendendo.demo.repository.query.PadraoRepositoryImpl;

public class ProdutoRepositorioImpl extends PadraoRepositoryImpl<Produto> {

    @Override
    public Filter[] getSearchNames() {
        return new Filter[]{new Filter("referencia", TypeSearch.EQUAL), new Filter("nome", TypeSearch.CONTAINING)};
    }

}
