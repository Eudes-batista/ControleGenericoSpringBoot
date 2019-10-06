package br.com.aprendendo.demo.service;

import br.com.aprendendo.demo.model.FormaPagamento;
import br.com.aprendendo.demo.repository.FormaPagamentoRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService extends DefaultService<FormaPagamento, Integer>{

    private final FormaPagamentoRepositorio formaPagamentoRepositorio;
    
    public FormaPagamentoService(FormaPagamentoRepositorio formaPagamentoRepositorio) {
        super(formaPagamentoRepositorio);
        this.formaPagamentoRepositorio = formaPagamentoRepositorio;
    }

    @Override
    public String[] getCamposASeremIgnoradosNaAlteracao() {
        return new String[]{"codigo"};
    }

    @Override
    public Page<FormaPagamento> pesquisarConteudo(String pesquisa, Pageable pageable) {
        return this.formaPagamentoRepositorio.findByNomeIgnoreCaseContaining(pesquisa, pageable);
    }
    
}
