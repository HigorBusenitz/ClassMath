package br.edu.utfpr.rest_biblioteca.resources;

import br.edu.utfpr.rest_biblioteca.domain.Log;
import br.edu.utfpr.rest_biblioteca.domain.Usuario;
import br.edu.utfpr.rest_biblioteca.services.LogService;
import br.edu.utfpr.rest_biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/logs")
public class LogResource {

    @Autowired
    private LogService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Log>> buscarTodos(){
        List<Log> usuarios = service.buscarTodos();
        return ResponseEntity.ok().body(usuarios);
    }


}
