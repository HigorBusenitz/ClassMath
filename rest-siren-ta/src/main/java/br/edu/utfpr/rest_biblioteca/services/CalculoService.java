package br.edu.utfpr.rest_biblioteca.services;

import br.edu.utfpr.rest_biblioteca.domain.Calculos;
import br.edu.utfpr.rest_biblioteca.repositories.CalculoRepository;
import br.edu.utfpr.rest_biblioteca.resources.exception.DataConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculoService {
    @Autowired
    private CalculoRepository repo;

    public Calculos buscarPorId(Integer id) {
        Optional<Calculos> obj = repo.findById(id);
        return obj.orElse(null);
    }

    public List<Calculos> buscarTodos() {
        return repo.findAll();
    }

    public Calculos inserirCalculo(Calculos calculos) {
        calculos.setCodigo(null);
        return repo.save(calculos);
    }

    public Calculos atualizarCalculo(Calculos calculos) {
        Calculos novoEmprestimo = buscarPorId(calculos.getCodigo());
        calculos(novoEmprestimo, calculos);

        return repo.save(novoEmprestimo);
    }

    public void calculos(Calculos novoEmprestimo, Calculos calculos) {
        novoEmprestimo.setCodigo(calculos.getCodigo());
        novoEmprestimo.setNome(calculos.getEquacao());
        novoEmprestimo.setEquacao(calculos.getEquacao());
    }

    public void deletaCalculo(Integer id) {
        buscarPorId(id);

        try{
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException exception) {
            throw new DataConstraintException("Este objeto está linkado com outro, não pode ser deletado");
        }
    }

}
