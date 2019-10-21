package br.com.aprendendo.demo.repository.query.formapagamento;

import br.com.aprendendo.demo.model.FormaPagamento;
import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.SearchType;
import br.com.aprendendo.demo.repository.query.PadraoRepositoryImpl;

public class FormaPagamentoRepositorioImpl extends PadraoRepositoryImpl<FormaPagamento>{

    @Override
    public Filter[] getSearchNames() {
        return new Filter[]{new Filter("nome", SearchType.CONTAINING)};
    }
    
}
