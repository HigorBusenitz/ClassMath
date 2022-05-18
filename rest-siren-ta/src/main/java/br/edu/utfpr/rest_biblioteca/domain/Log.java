package br.edu.utfpr.rest_biblioteca.domain;

import java.util.Date;

public class Log {

    private String descricao;
    private Date dahora;


    public Log(String descricao, Date dahora) {
        this.descricao = descricao;
        this.dahora = dahora;
    }
}
