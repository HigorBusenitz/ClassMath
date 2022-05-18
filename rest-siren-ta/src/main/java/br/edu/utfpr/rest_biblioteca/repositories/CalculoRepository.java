package br.edu.utfpr.rest_biblioteca.repositories;

import br.edu.utfpr.rest_biblioteca.domain.Calculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoRepository extends JpaRepository<Calculos, Integer> {
}
