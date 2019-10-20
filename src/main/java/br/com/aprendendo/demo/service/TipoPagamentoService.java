package br.com.aprendendo.demo.service;

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
    public Page<TipoPagamento> pesquisarConteudo(String pesquisa, Pageable pageable) {
        return this.tipoPagamentoRepositorio.filtrar(pesquisa, pageable,TipoPagamento.class);       
    }

    @Override
    public String[] getCamposASeremIgnoradosNaAlteracao() {
        return new String[]{"codigo"};
    }

}
