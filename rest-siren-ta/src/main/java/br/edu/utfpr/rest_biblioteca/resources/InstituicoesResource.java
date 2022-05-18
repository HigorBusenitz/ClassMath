package br.edu.utfpr.rest_biblioteca.resources;

import br.edu.utfpr.rest_biblioteca.domain.Instituicoes;
import br.edu.utfpr.rest_biblioteca.services.InstituicoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/instituicoes")
public class InstituicoesResource {
    @Autowired
    private InstituicoesService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Instituicoes> listarInstituicoesPorId(@PathVariable Integer id) {
        Instituicoes obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Instituicoes>> buscarTodos() {
        List<Instituicoes> instituicoes = service.buscarTodos();
        return ResponseEntity.ok().body(instituicoes);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirInstituicoes(@RequestBody Instituicoes instituicoes) {
        instituicoes = service.inserirInstituicoes(instituicoes);

        //define a url para consultar o objeto que foi criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instituicoes.getCodigo()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizarInstituicoes(@RequestBody Instituicoes instituicoes) {
        Instituicoes instituicoesObj = service.atualizarInstituicoes(instituicoes);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletaInstituicoes(@PathVariable Integer id) {
        service.deletaInstituicoes(id);
        return ResponseEntity.noContent().build();
    }
}
