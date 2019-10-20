package br.com.aprendendo.demo.repository.query.cliente;

import br.com.aprendendo.demo.model.Cliente;
import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.TypeSearch;
import br.com.aprendendo.demo.repository.query.PadraoRepositoryImpl;

public class ClienteRepositorioImpl extends PadraoRepositoryImpl<Cliente> {

    @Override
    public Filter[] getSearchNames() {
        return new Filter[]{new Filter("telefone", TypeSearch.EQUAL), new Filter("nome", TypeSearch.CONTAINING)};
    }

}
