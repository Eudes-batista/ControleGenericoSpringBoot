package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.Usuario;
import br.com.aprendendo.demo.repository.query.Usuario.UsuarioRepositorioQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>, UsuarioRepositorioQuery{
    
}
