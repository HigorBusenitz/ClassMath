package br.edu.utfpr.rest_biblioteca.resources;

import br.edu.utfpr.rest_biblioteca.domain.Calculos;
import br.edu.utfpr.rest_biblioteca.services.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/calculos")
public class CalculoResource {
    @Autowired
    private CalculoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Calculos> listarCalculoPorId(@PathVariable Integer id) {
        Calculos obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Calculos>> buscarTodos() {
        List<Calculos> calculos = service.buscarTodos();
        return ResponseEntity.ok().body(calculos);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCalculo(@RequestBody Calculos calculos) {
        calculos = service.inserirCalculo(calculos);

        //define a url para consultar o objeto que foi criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(calculos.getCodigo()).toUri();

        return ResponseEntity.created(uri).build();
    }

//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<Void> atualizarCalculos(@RequestBody Calculos calculos) {
//        Calculos livroObj = service.atualizarCalculo(calculos);
//        return ResponseEntity.noContent().build();
//    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizarCalculo(@RequestBody Calculos calculos) {
        Calculos calculos1 = service.atualizarCalculo(calculos);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletaCalculos(@PathVariable Integer id) {
        service.deletaCalculo(id);
        return ResponseEntity.noContent().build();
    }

}
