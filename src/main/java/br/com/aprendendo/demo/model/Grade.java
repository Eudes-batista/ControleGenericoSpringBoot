package br.com.aprendendo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "grade")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Grade implements Serializable {

    @EmbeddedId
    private GradePK gradePK;

    @Column(name = "nome", length = 30, nullable = true)
    private String nome;
    
    @Column(name = "cor", length = 30, nullable = false)
    private String cor;
    
    @Column(name = "tamanho", length = 3, nullable = false)
    private String tamanho;
    
    @Column(name = "genero", length = 10, nullable = false)
    private String genero;
    
    @Column(name = "quantidade", precision = 6, scale = 3, nullable = false)
    private Double quantidade;
    

}
