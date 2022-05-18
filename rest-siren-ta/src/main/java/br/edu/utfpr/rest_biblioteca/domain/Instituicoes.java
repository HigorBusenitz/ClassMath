package br.edu.utfpr.rest_biblioteca.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @Entity
public class Instituicoes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    private boolean ativo;


    public Instituicoes(Integer codigo, String nome, boolean ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.ativo = ativo;
    }


}
