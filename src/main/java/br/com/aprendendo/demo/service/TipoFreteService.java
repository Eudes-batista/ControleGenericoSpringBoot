package br.com.aprendendo.demo.service;

import br.com.aprendendo.demo.model.TipoFrete;
import br.com.aprendendo.demo.repository.TipoFreteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TipoFreteService extends DefaultService<TipoFrete, Integer>{

    private final TipoFreteRepositorio tipoFreteRepositorio;
    
    @Autowired
    public TipoFreteService(TipoFreteRepositorio tipoFreteRepositorio) {
        super(tipoFreteRepositorio);
        this.tipoFreteRepositorio = tipoFreteRepositorio;
    }

    @Override
    public String[] getCamposASeremIgnoradosNaAlteracao() {
        return new String[]{"codigo"};
    }
    
    @Override
    public Page<?> pesquisarConteudo(String pesquisa, Pageable pageable) {
        return this.tipoFreteRepositorio.filtrar(pesquisa, pageable, TipoFrete.class);
    }
        
}
