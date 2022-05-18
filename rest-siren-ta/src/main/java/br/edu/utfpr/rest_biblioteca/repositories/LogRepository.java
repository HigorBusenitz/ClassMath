package br.edu.utfpr.rest_biblioteca.repositories;

import br.edu.utfpr.rest_biblioteca.domain.Calculos;
import br.edu.utfpr.rest_biblioteca.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, String> {
}
