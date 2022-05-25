package br.edu.utfpr.rest_biblioteca.repositories;

import br.edu.utfpr.rest_biblioteca.domain.Log;
import br.edu.utfpr.rest_biblioteca.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, String> {
}
