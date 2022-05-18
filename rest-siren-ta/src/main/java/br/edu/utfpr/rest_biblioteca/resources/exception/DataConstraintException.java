package br.edu.utfpr.rest_biblioteca.resources.exception;

public class DataConstraintException extends RuntimeException{
    public DataConstraintException(String mensagem) {
        super(mensagem);
    }
}
