package br.com.aprendendo.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@EqualsAndHashCode(of = {"numeroDocumento", "item"})
@Embeddable
public class FichaProdutoItemPK implements Serializable {

    @Column(name = "numero_documento", length = 60, nullable = false)
    private String numeroDocumento;

    @Column(name = "item", length = 3, nullable = false)
    private Integer item;
    
}
