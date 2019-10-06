package br.com.aprendendo.demo.model;

import br.com.aprendendo.demo.model.base.EntityBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@EqualsAndHashCode(of = {"codigo"})
@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento implements EntityBase<Integer>,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", length = 2, nullable = false)
    private Integer codigo;

    @Column(name = "nome", length = 30, nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name="codigo_tipo_pagamento",nullable = false,referencedColumnName = "codigo")
    private TipoPagamento tipoPagamento;

    @Transient
    @JsonIgnore
    @Override
    public Integer getPrimary() {
        return this.codigo;
    }

}
