package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.FormaPagamento;
import br.com.aprendendo.demo.repository.FormaPagamentoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "formaPagamento")
@CrossOrigin
public class FormaPagamentoControle {
 
    @Autowired
    private FormaPagamentoRepositorio formaPagamentoRepositorio;

    @GetMapping
    public ResponseEntity<?> listarFormaPagamento() {
        List<FormaPagamento> formaPagamentos = this.formaPagamentoRepositorio.findAll();
        return new ResponseEntity(formaPagamentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody FormaPagamento formaPagamento) {
        FormaPagamento formaPagamentoSalvo = this.formaPagamentoRepositorio.save(formaPagamento);
        return new ResponseEntity(formaPagamentoSalvo,HttpStatus.CREATED);
    }
    
    @DeleteMapping("{codigo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable("codigo") Integer codigo) {
        this.formaPagamentoRepositorio.deleteById(codigo);
    }
    
}
