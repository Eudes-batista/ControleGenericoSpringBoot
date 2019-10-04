package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cliente")
public class ClienteControle extends DefaultController<Cliente, String> {

//    @Autowired
//    private ClienteRepositorio clienteRepositorio;
//
//    @Autowired
//    private ApplicationEventPublisher applicationEventPublisher;
//
//    @GetMapping
//    public ResponseEntity<?> listarClientes(Pageable pageable) {
//        Page<Cliente> clientes = this.clienteRepositorio.findAll(pageable);
//        return new ResponseEntity(clientes, HttpStatus.OK);
//    }
//
//    @GetMapping("/pesquisa/{pesquisa}")
//    public ResponseEntity<?> listarClientesPorTelefoneOuNome(@PathVariable("pesquisa") String pesquisa, Pageable pageable) {
//        Page<Cliente> clientes = this.clienteRepositorio.findByTelefoneOrNomeIgnoreCaseContaining(pesquisa, pesquisa.toUpperCase(), pageable);
//        return new ResponseEntity(clientes, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<?> salvar(@Valid @RequestBody Cliente cliente, HttpServletResponse httpServletResponse) {
//        Cliente clienteSalvo = this.clienteRepositorio.save(cliente);
////        ResourceCreateEvent<String> resourceCreateEvent = new ResourceCreateEvent<>(this, httpServletResponse, clienteSalvo.getTelefone());
////        applicationEventPublisher.publishEvent(resourceCreateEvent);
//        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
//    }
//
//    @DeleteMapping("{codigo}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void excluir(@PathVariable("codigo") String codigo) {
//        this.clienteRepositorio.deleteById(codigo);
//    }
}
