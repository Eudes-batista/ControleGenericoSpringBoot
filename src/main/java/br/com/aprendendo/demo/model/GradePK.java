package br.com.aprendendo.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode
@Embeddable
public class GradePK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="codigo_produto",nullable = false,referencedColumnName = "referencia",foreignKey = @ForeignKey(name="gradeFKProduto"))
    private Produto produto;
    
    @Column(name="codigo",length=4,nullable=false)
    private Integer codigo;
    
}
