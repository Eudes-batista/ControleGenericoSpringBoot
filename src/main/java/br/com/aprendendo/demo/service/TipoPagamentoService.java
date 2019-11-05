package br.com.aprendendo.demo.service;

import br.com.aprendendo.demo.model.TipoFrete;
import br.com.aprendendo.demo.model.TipoPagamento;
import br.com.aprendendo.demo.repository.TipoPagamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TipoPagamentoService extends DefaultService<TipoPagamento, Integer> {

    private final TipoPagamentoRepositorio tipoPagamentoRepositorio;

    @Autowired
    public TipoPagamentoService(TipoPagamentoRepositorio repositorio) {
        super(repositorio);
        this.tipoPagamentoRepositorio = repositorio;
    }

    @Override
    public String[] getCamposASeremIgnoradosNaAlteracao() {
        return new String[]{"codigo"};
    }

    @Override
    public Page<?> pesquisarConteudo(String pesquisa, Pageable pageable) {
        return tipoPagamentoRepositorio.filtrar(pesquisa, pageable, TipoFrete.class);
    }

}
