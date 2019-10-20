package br.com.aprendendo.demo.service;

import br.com.aprendendo.demo.model.Cliente;
import br.com.aprendendo.demo.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends DefaultService<Cliente, String> {

    private final ClienteRepositorio repositorio;

    @Autowired
    public ClienteService(ClienteRepositorio repositorio) {
        super(repositorio);
        this.repositorio = repositorio;
    }

    @Override
    public Page<Cliente> pesquisarConteudo(String pesquisa, Pageable pageable) {
        return this.repositorio.filtrar(pesquisa, pageable, Cliente.class);
    }

    @Override
    public String[] getCamposASeremIgnoradosNaAlteracao() {
        return new String[]{"telefone"};
    }

}
