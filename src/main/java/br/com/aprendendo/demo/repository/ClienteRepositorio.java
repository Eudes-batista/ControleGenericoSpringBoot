package br.com.aprendendo.demo.repository;

import org.springframework.stereotype.Repository;
import br.com.aprendendo.demo.model.Cliente;
import br.com.aprendendo.demo.repository.query.cliente.ClienteRepositorioQuery;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String>,ClienteRepositorioQuery {

}
