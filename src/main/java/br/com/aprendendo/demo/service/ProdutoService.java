package br.com.aprendendo.demo.service;

import br.com.aprendendo.demo.model.Produto;
import br.com.aprendendo.demo.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends DefaultService<Produto, String> {

    private final ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ProdutoService(ProdutoRepositorio produtoRepositorio) {
        super(produtoRepositorio);
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public String[] getCamposASeremIgnoradosNaAlteracao() {
        return new String[]{"referencia"};
    }

    @Override
    public Page<Produto> pesquisarConteudo(String pesquisa, Pageable pageable) {
        return this.produtoRepositorio.findByReferenciaOrNomeIgnoreCaseContaining(pesquisa, pesquisa.toUpperCase(), pageable);
    }

}
