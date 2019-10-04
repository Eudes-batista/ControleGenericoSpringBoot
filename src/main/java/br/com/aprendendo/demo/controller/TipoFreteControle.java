package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.TipoFrete;
import br.com.aprendendo.demo.repository.TipoFreteRepositorio;
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
@RequestMapping(path = "tipoFrete")
@CrossOrigin
public class TipoFreteControle {
 
    @Autowired
    private TipoFreteRepositorio tipoFreteRepositorio;

    @GetMapping
    public ResponseEntity<?> listarTipoFrete() {
        List<TipoFrete> tipoFretes = this.tipoFreteRepositorio.findAll();
        return new ResponseEntity(tipoFretes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody TipoFrete tipoFrete) {
        TipoFrete tipoFreteSalvo = this.tipoFreteRepositorio.save(tipoFrete);
        return new ResponseEntity(tipoFreteSalvo,HttpStatus.CREATED);
    }
    
    @DeleteMapping("{codigo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable("codigo") Integer codigo) {
        this.tipoFreteRepositorio.deleteById(codigo);
    }
    
}
