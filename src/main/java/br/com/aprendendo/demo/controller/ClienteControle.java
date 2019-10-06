package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Cliente;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cliente")
public class ClienteControle extends DefaultController<Cliente, String> {

    @Override
    public Map<String, Object> getParams(Cliente t) {
        Map<String, Object> map = DefaultController.criarParams();
        map.put("telefone", t.getTelefone());
        return map;
    }
}
