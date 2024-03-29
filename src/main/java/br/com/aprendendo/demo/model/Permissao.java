package br.com.aprendendo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "permissao")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"codigo"})
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissao implements Serializable {

    @Id
    @Column(name = "codigo", length = 20, nullable = false)
    @NotNull
    @Size(max = 20)
    private Long codigo;

    @Size(max = 50)
    @NotEmpty
    @NotNull
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;

}
