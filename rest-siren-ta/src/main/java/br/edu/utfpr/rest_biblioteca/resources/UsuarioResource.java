package br.edu.utfpr.rest_biblioteca.resources;

import br.edu.utfpr.rest_biblioteca.domain.Usuario;
import br.edu.utfpr.rest_biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> listarUsuarioPorId(@PathVariable Integer id) {
        Usuario obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> buscarTodos(){
        List<Usuario> usuarios = service.buscarTodos();
        return ResponseEntity.ok().body(usuarios);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirUsuario(@RequestBody Usuario usuario) {
        usuario = service.inserirUsuario(usuario);

        //define a url para consultar o objeto que foi criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getCodigo()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioObj = service.atualizarUsuario(usuario);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletaUsuario(@PathVariable Integer id) {
        service.deletaUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
