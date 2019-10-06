package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Produto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "produto")
public class ProdutoControle extends DefaultController<Produto, String>{
}
