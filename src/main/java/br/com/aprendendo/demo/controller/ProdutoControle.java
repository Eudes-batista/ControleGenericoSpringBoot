package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Produto;
import br.com.aprendendo.demo.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping(path = "produto")
@CrossOrigin
public class ProdutoControle {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @GetMapping
    public ResponseEntity<?> listarProdutos(Pageable pageable) {
        Page<Produto> produtos = this.produtoRepositorio.findAll(pageable);
        return new ResponseEntity(produtos, HttpStatus.OK);
    }

    @GetMapping("/pesquisa/{pesquisa}")
    public ResponseEntity<?> listarProdutosPorTelefoneOuNome(@PathVariable("pesquisa") String pesquisa, Pageable pageable) {
        Page<Produto> produtos = this.produtoRepositorio.pesquisarPorReferenciaOuNome(pesquisa, pageable);
        return new ResponseEntity(produtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Produto produto) {
        Produto produtoSalvo = this.produtoRepositorio.save(produto);
        return new ResponseEntity(produtoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("{codigo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable("codigo") String codigo) {
        this.produtoRepositorio.deleteById(codigo);
    }

}
