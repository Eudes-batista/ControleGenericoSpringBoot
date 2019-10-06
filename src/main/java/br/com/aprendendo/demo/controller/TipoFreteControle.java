package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.TipoFrete;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tipoFrete")
public class TipoFreteControle extends DefaultController<TipoFrete, Integer> {
    
    @Override
    public Map<String, Object> getParams(TipoFrete t) {
        Map<String, Object> map = DefaultController.criarParams();
        map.put("codigo", t.getCodigo());
        return map;
    }
}
