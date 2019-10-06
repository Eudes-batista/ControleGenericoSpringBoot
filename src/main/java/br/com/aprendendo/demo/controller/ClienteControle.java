package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cliente")
public class ClienteControle extends DefaultController<Cliente, String> {
}
