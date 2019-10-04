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
        return this.tipoPagamentoRepositorio.findByNomeIgnoreCaseContaining(pesquisa, pageable);
    }
//    @Autowired
//    private TipoPagamentoRepositorio tipoPagamentoRepositorio;
//
//    @Override
//    public Page<TipoPagamento> listarTodos(Pageable pageable) {
//        return this.tipoPagamentoRepositorio.findAll(pageable);
//    }
//
//
//    @Override
//    public TipoPagamento salvar(TipoPagamento t) {
//        return this.tipoPagamentoRepositorio.save(t);
//    }
//
//    @Override
//    public TipoPagamento alterar(Integer id, TipoPagamento t) {
//        Optional<TipoPagamento> optionalTipoPagamento = this.tipoPagamentoRepositorio.findById(id);
//        if (optionalTipoPagamento.isEmpty()) {
//            return null;
//        }
//        TipoPagamento tipoPagamento = optionalTipoPagamento.get();
//        BeanUtils.copyProperties(t, tipoPagamento, "codigo");
//        return this.tipoPagamentoRepositorio.save(tipoPagamento);
//    }
//
//    @Override
//    public TipoPagamento buscar(Integer id) {
//        Optional<TipoPagamento> optionalTipoPagamento = this.tipoPagamentoRepositorio.findById(id);
//        return optionalTipoPagamento.isPresent() ? optionalTipoPagamento.get() : null;
//    }
//
//    @Override
//    public void excluir(Integer id) {
//        this.tipoPagamentoRepositorio.deleteById(id);
//    }

}
