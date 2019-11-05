package br.com.aprendendo.demo.repository.query.cliente;

import br.com.aprendendo.demo.model.Cliente;
import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.SearchType;
import br.com.aprendendo.demo.repository.query.PadraoRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ClienteRepositorioImpl extends PadraoRepositoryImpl<Cliente> {

    @Override
    public Filter[] getSearchNames() {
        return new Filter[]{new Filter("telefone", SearchType.EQUAL), new Filter("nome", SearchType.CONTAINING)};
    }

}
