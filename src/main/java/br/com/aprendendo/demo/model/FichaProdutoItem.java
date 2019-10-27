package br.com.aprendendo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ficha_producao_item")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FichaProdutoItem implements Serializable {

    @EmbeddedId
    private FichaProdutoItemPK fichaProdutoItemPK;

    @ManyToOne
    @JoinColumns(value = {
        @JoinColumn(name = "codigo_grade", nullable = false),
        @JoinColumn(name = "codigo_produto", nullable = false)},
            foreignKey = @ForeignKey(name = "ficha_producao_itemFKgrade"))
    private Grade grade;

    @Column(name = "quantidade", precision = 6, scale = 3, nullable = false)
    private Double quantidade;
}
