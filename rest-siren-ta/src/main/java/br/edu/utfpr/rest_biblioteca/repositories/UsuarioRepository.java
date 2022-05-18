package br.edu.utfpr.rest_biblioteca.repositories;

import br.edu.utfpr.rest_biblioteca.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
