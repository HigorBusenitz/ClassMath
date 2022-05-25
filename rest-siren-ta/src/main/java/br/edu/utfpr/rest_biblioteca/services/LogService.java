package br.edu.utfpr.rest_biblioteca.services;

import br.edu.utfpr.rest_biblioteca.domain.Log;
import br.edu.utfpr.rest_biblioteca.domain.Usuario;
import br.edu.utfpr.rest_biblioteca.repositories.LogRepository;
import br.edu.utfpr.rest_biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository repo;

    public List<Log> buscarTodos() {return repo.findAll();}
}
