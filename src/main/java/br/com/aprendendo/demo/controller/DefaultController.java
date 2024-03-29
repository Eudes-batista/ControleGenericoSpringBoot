package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.event.ResourceCreateEvent;
import br.com.aprendendo.demo.service.GenericService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin
public abstract class DefaultController<T, ID> {

    @Autowired
    @Getter
    private GenericService<T, ID> genericService;

    private static Map<String, Object> params = null;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISA') and #oauth2.hasScope('read')")
    public ResponseEntity<Page<T>> listarTodos(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.genericService.listarTodos(pageable));
    }

    @GetMapping("{content}/search")
    @PreAuthorize("hasAuthority('ROLE_PESQUISA') and #oauth2.hasScope('read')")
    public ResponseEntity<Page<?>> listarConteudo(@PathVariable("content") String content, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.genericService.pesquisarConteudo(content, pageable));
    }

    @GetMapping("{content}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISA') and #oauth2.hasScope('read')")
    public ResponseEntity<T> buscar(@PathVariable("content") ID id) {
        T t = this.genericService.buscar(id);
        return t == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(t);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')")
    public ResponseEntity<T> salvar(@RequestBody @Valid T t, HttpServletResponse httpServletResponse) {
        T tSalvo = this.genericService.salvar(t);
        this.applicationEventPublisher.publishEvent(new ResourceCreateEvent(this, httpServletResponse, this.getParams(tSalvo)));
        return ResponseEntity.status(HttpStatus.CREATED).body(tSalvo);
    }

    @PutMapping("{content}")
    @PreAuthorize("hasAuthority('ROLE_ALTERAR') and #oauth2.hasScope('write')")
    public T alterar(@PathVariable("content") ID id, @RequestBody @Valid T t) {
        return this.genericService.alterar(id, t);
    }

    @DeleteMapping("{content}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_DELETAR') and #oauth2.hasScope('write')")
    public void excluir(@PathVariable("content") ID id) {
        this.genericService.excluir(id);
    }

    public static Map<String, Object> criarParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        params.clear();
        return params;
    }

    public abstract Map<String, Object> getParams(T t);

}
