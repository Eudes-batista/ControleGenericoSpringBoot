package br.com.aprendendo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"codigo"})
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable {

    @Id
    @Column(name = "codigo", length = 20, nullable = false)
    @NotNull
    @Size(max = 20)
    private Long codigo;

    @Size(max = 20)
    @NotEmpty
    @NotNull
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Size(max = 50)
    @NotEmpty
    @NotNull
    @Column(name = "email", length = 50, nullable = false)
    @Email
    private String email;

    @Size(max = 150)
    @NotEmpty
    @NotNull
    @Column(name = "senha", length = 150, nullable = false)
    private String senha;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name= "usuario_permissao", joinColumns = @JoinColumn(name="codigo_usuario")
       ,inverseJoinColumns = @JoinColumn(name="codigo_permissao")
    )
    private List<Permissao> permissoes;

}
