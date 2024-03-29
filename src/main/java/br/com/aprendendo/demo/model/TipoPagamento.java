package br.com.aprendendo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@EqualsAndHashCode(of = {"codigo"})
@Entity
@Table(name = "tipo_pagamento")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoPagamento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", length = 2, nullable = false)
    private Integer codigo;

    @NotNull
    @Size(max=30)
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;
}
