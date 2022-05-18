package br.edu.utfpr.rest_biblioteca.repositories;

import br.edu.utfpr.rest_biblioteca.domain.Instituicoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicoesRepository extends JpaRepository<Instituicoes, Integer> {
}
