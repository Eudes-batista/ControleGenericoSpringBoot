package br.com.aprendendo.demo.security;

import br.com.aprendendo.demo.model.Usuario;
import br.com.aprendendo.demo.repository.UsuarioRepositorio;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {        
        Optional<Usuario> usuarioOptional = this.usuarioRepositorio.findByEmailIgnoreCase(email);
        Usuario usuario = usuarioOptional.orElseThrow( () -> new UsernameNotFoundException("Usuário ou senha incoreta"));
        return new UsuarioSistema(usuario, getPermissoes(usuario)); 
    }

    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        usuario.getPermissoes().forEach(permissao -> authorities.add(new SimpleGrantedAuthority(permissao.getDescricao().toUpperCase())));
        return authorities;
    }
    
}
