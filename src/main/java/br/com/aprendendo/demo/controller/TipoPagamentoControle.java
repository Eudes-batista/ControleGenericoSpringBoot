package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.TipoPagamento;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tipoPagamento")
public class TipoPagamentoControle extends DefaultController<TipoPagamento, Integer> {
}
