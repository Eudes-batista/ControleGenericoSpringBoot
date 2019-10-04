package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.TipoPagamento;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tipoPagamento")
public class TipoPagamentoControle extends DefaultController<TipoPagamento, Integer> {
// 
//    @Autowired
//    private TipoPagamentoRepositorio tipoPagamentoRepositorio;

//    @GetMapping
//    public ResponseEntity<?> listarTipoPagamento() {
//        List<TipoPagamento> tipoPagamentos = this.tipoPagamentoRepositorio.findAll();
//        return new ResponseEntity(tipoPagamentos, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<?> salvar(@RequestBody TipoPagamento tipoPagamento) {
//        TipoPagamento tipoPagamentoSalvo = this.tipoPagamentoRepositorio.save(tipoPagamento);
//        return new ResponseEntity(tipoPagamentoSalvo,HttpStatus.CREATED);
//    }
//    
//    @DeleteMapping("{codigo}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void excluir(@PathVariable("codigo") Integer codigo) {
//        this.tipoPagamentoRepositorio.deleteById(codigo);
//    }
}
