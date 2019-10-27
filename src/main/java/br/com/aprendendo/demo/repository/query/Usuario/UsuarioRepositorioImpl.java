package br.com.aprendendo.demo.repository.query.Usuario;

import br.com.aprendendo.demo.model.Usuario;
import br.com.aprendendo.demo.repository.filter.Filter;
import br.com.aprendendo.demo.repository.filter.SearchType;
import br.com.aprendendo.demo.repository.query.PadraoRepositoryImpl;

public class UsuarioRepositorioImpl extends PadraoRepositoryImpl<Usuario>{

    @Override
    public Filter[] getSearchNames() {
        return new Filter[]{new Filter("email", SearchType.EQUAL)};
    }
    
}
