package br.com.aprendendo.demo.controller;

import br.com.aprendendo.demo.model.Cliente;
import br.com.aprendendo.demo.report.ClientReport;
import br.com.aprendendo.demo.repository.ClienteRepositorio;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cliente")
public class ClienteControle extends DefaultController<Cliente, String> {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public Map<String, Object> getParams(Cliente t) {
        Map<String, Object> map = DefaultController.criarParams();
        map.put("telefone", t.getTelefone());
        return map;
    }

    @GetMapping(value = "/pdfreport", produces = MediaType.APPLICATION_PDF_VALUE)
    @PreAuthorize("hasAuthority('ROLE_PESQUISA') and #oauth2.hasScope('read')")
    public ResponseEntity<InputStreamResource> clientReport(HttpServletRequest httpServletRequest) {
        String nomeArquivo = httpServletRequest.getHeader("fileName");
        var clientes = this.clienteRepositorio.findAll();
        ByteArrayInputStream bis = ClientReport.clientReport(clientes);
        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + nomeArquivo + ".pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
