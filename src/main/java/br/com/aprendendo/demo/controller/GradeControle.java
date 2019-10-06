package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Grade;
import br.com.aprendendo.demo.model.GradePK;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
public class GradeControle extends DefaultController<Grade, GradePK> {

    @Override
    public Map<String, Object> getParams(Grade t) {
        Map<String, Object> params = DefaultController.criarParams();
        params.put("codigo", t.getGradePK().getCodigo());
        params.put("codigoProduto", t.getGradePK().getProduto().getReferencia());
        return params;
    }

}
