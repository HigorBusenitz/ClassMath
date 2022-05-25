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
        Instituicoes instituicoes1 = buscarPorId(instituicoes.getCodigo());
        atualizarInstituicoesObj(instituicoes1, instituicoes);

        return repo.save(instituicoes1);
    }

    public void atualizarInstituicoesObj(Instituicoes novaInstituicao, Instituicoes instituicoes) {
        novaInstituicao.setCodigo(instituicoes.getCodigo());
        novaInstituicao.setNome(instituicoes.getNome());
        novaInstituicao.setAtivo(instituicoes.isAtivo());
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
