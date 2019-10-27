package br.com.aprendendo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@EqualsAndHashCode(of = {"numeroDocumento"})
@Entity
@Table(name = "ficha_producao")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FichaProducao implements Serializable{
    
    @Id
    @Column(name = "numero_documento", length = 60, nullable = false)
    private String numeroDocumento;

    @Column(name = "nome", length = 60, nullable = true)
    private String nome;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = true)
    private Date data;
    
    @ManyToOne
    @JoinColumn(name="codigo_produto",nullable = false,referencedColumnName = "referencia",foreignKey = @ForeignKey(name="ficha_producaoFKProduto"))
    private Produto produto;
    
}
