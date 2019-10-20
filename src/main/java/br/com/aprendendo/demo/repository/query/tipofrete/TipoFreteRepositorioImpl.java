package br.com.aprendendo.demo.repository.query.tipofrete;

import br.com.aprendendo.demo.model.TipoFrete;
import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.SearchType;
import br.com.aprendendo.demo.repository.query.PadraoRepositoryImpl;

public class TipoFreteRepositorioImpl extends PadraoRepositoryImpl<TipoFrete> {

    @Override
    public Filter[] getSearchNames() {
        return new Filter[]{new Filter("nome", SearchType.CONTAINING)};
    }

}
