package br.com.aprendendo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.aprendendo.demo.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    public Page<Cliente> findByTelefoneOrNomeIgnoreCaseContaining(String telefone,String nome, Pageable pageable);

}
