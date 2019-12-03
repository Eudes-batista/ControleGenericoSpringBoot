package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.Usuario;
import br.com.aprendendo.demo.repository.query.usuario.UsuarioRepositorioQuery;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>, UsuarioRepositorioQuery{
    
    public Optional<Usuario> findByEmailIgnoreCase(String email);
    
}
