package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.FormaPagamento;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formaPagamento")
public class FormaPagamentoController extends DefaultController<FormaPagamento, Integer> {

}
