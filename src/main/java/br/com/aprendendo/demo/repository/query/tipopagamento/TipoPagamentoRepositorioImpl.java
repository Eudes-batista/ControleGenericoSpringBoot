package br.com.aprendendo.demo.repository.query.tipopagamento;

import br.com.aprendendo.demo.model.TipoPagamento;
import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.TypeSearch;
import br.com.aprendendo.demo.repository.query.PadraoRepositoryImpl;

public class TipoPagamentoRepositorioImpl extends PadraoRepositoryImpl<TipoPagamento> {

    @Override
    public Filter[] getSearchNames() {
        return new Filter[]{new Filter("nome", TypeSearch.CONTAINING)};
    }

}
