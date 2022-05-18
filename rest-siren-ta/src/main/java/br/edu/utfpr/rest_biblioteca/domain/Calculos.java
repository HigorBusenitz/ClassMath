package br.edu.utfpr.rest_biblioteca.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor @Entity
public class Calculos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nome;
    private String equacao;

    public Calculos(Integer codigo, String nome, String equacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.equacao = equacao;
    }
}
