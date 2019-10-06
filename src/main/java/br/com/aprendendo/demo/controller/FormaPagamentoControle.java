package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.FormaPagamento;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "formaPagamento")
public class FormaPagamentoControle extends DefaultController<FormaPagamento, Integer> {   
    
    @Override
    public Map<String, Object> getParams(FormaPagamento t) {
        Map<String, Object> map = DefaultController.criarParams();
        map.put("codigo", t.getCodigo());
        return map;
    }
}
