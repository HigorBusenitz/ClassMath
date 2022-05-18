package br.edu.utfpr.rest_biblioteca.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer codigo;

    private String nome;
    private String email;
    private boolean ativo;

    public Usuario(Integer codigo, String nome, String email, boolean ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
    }
}
