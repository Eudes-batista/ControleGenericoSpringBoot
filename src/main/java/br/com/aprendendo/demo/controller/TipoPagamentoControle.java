package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.TipoPagamento;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tipoPagamento")
public class TipoPagamentoControle extends DefaultController<TipoPagamento, Integer> {

    @Override
    public Map<String, Object> getParams(TipoPagamento t) {
        Map<String, Object> map = DefaultController.criarParams();
        map.put("codigo", t.getCodigo());
        return map;
    }
}
