package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Produto;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "produto")
public class ProdutoControle extends DefaultController<Produto, String>{

    @Override
    public Map<String, Object> getParams(Produto t) {
        Map<String, Object> map = DefaultController.criarParams();
        map.put("referencia", t.getReferencia());
        return map;
    }
}
