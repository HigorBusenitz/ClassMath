package br.edu.utfpr.rest_biblioteca.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String descricao;
    private Date dahora;


    public Log(String descricao, Date dahora) {
        this.descricao = descricao;
        this.dahora = dahora;
    }
}
