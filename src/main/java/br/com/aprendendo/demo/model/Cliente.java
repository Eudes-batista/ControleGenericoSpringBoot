package br.com.aprendendo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"telefone"})
@Entity
@Table(name = "cliente")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente implements Serializable {

    @Id
    @Column(name = "telefone", length = 9, nullable = false)
    @NotNull
    @Size(max=9)
    private String telefone;

    @NotNull
    @Size(max=50)
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = true)
    private String cpf;

    @Column(name = "cep", length = 8, nullable = true)
    private String cep;

    @Column(name = "endereco", length = 50, nullable = true)
    private String endereco;

    @Column(name = "numero", length = 5, nullable = true)
    private String numero;

    @Column(name = "estado", length = 50, nullable = true)
    private String estado;

    @Column(name = "cidade", length = 50, nullable = true)
    private String cidade;
    
    @Column(name = "status", nullable = false)
    private Boolean status;

}
