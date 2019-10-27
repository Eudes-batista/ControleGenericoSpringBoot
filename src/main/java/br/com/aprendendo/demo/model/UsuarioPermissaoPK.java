package br.com.aprendendo.demo.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UsuarioPermissaoPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="codigo_usuario",nullable = false,foreignKey = @ForeignKey(name="usuarioPermissaoFKusuario"))
    @NotNull
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="codigo_permissao",nullable = false,foreignKey = @ForeignKey(name="usuarioPermissaoFKpermissao"))
    @NotNull
    private Permissao permissao;
    
}
