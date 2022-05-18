package br.edu.utfpr.rest_biblioteca.services;

import br.edu.utfpr.rest_biblioteca.domain.Instituicoes;
import br.edu.utfpr.rest_biblioteca.repositories.InstituicoesRepository;
import br.edu.utfpr.rest_biblioteca.resources.exception.DataConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicoesService {
    @Autowired
    private InstituicoesRepository repo;

    public Instituicoes buscarPorId(Integer id) {
        Optional<Instituicoes> obj = repo.findById(id); //Spring 2.0 >>
        return obj.orElse(null);
    }

    public List<Instituicoes> buscarTodos() {
        return repo.findAll();
    }

    public Instituicoes inserirInstituicoes(Instituicoes instituicoes) {
        instituicoes.setCodigo(null);
        return repo.save(instituicoes);
    }

    public Instituicoes atualizarInstituicoes(Instituicoes instituicoes) {
        Instituicoes novoLivro = buscarPorId(instituicoes.getCodigo());
        atualizarInstituicoesObj(novoLivro, instituicoes);

        return repo.save(novoLivro);
    }

    public void atualizarInstituicoesObj(Instituicoes novoLivro, Instituicoes instituicoes) {
        novoLivro.setCodigo(instituicoes.getCodigo());
        novoLivro.setNome(instituicoes.getNome());
    }

    public void deletaInstituicoes(Integer id) {
        buscarPorId(id);

        try{
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException exception) {
            throw new DataConstraintException("Este objeto está linkado com outro, não pode ser deletado");
        }
    }
}
