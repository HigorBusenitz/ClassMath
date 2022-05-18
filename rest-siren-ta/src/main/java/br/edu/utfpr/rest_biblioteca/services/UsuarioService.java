package br.edu.utfpr.rest_biblioteca.services;

import br.edu.utfpr.rest_biblioteca.domain.Usuario;
import br.edu.utfpr.rest_biblioteca.repositories.UsuarioRepository;
import br.edu.utfpr.rest_biblioteca.resources.exception.DataConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElse(null);
    }

    public List<Usuario> buscarTodos() {return repo.findAll();}

    public Usuario inserirUsuario(Usuario usuario) {
        usuario.setCodigo(null);
        return repo.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        Usuario novoUsuario = buscarPorId(usuario.getCodigo());
        atualizarUsuarioObj(novoUsuario, usuario);

        return repo.save(novoUsuario);
    }

    private void atualizarUsuarioObj(Usuario novoUsuario, Usuario usuario) {
        novoUsuario.setNome(usuario.getNome());
    }

    public void deletaUsuario(Integer id) {
        buscarPorId(id);

        try{
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException exception) {
            throw new DataConstraintException("Este objeto está linkado com outro, não pode ser deletado");
        }
    }
}
