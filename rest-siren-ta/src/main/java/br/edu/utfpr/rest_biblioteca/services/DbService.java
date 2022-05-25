package br.edu.utfpr.rest_biblioteca.services;

import br.edu.utfpr.rest_biblioteca.domain.Calculos;
import br.edu.utfpr.rest_biblioteca.domain.Instituicoes;
import br.edu.utfpr.rest_biblioteca.domain.Usuario;
import br.edu.utfpr.rest_biblioteca.repositories.CalculoRepository;
import br.edu.utfpr.rest_biblioteca.repositories.InstituicoesRepository;
import br.edu.utfpr.rest_biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {
    @Autowired
    private InstituicoesRepository instituicoesRepository;

    @Autowired
    private CalculoRepository calculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void iniciarBancoDeDados() {
        Instituicoes i1 = new Instituicoes(1, "fag",true);
        Instituicoes i2 = new Instituicoes(2, "utfpr",false);

        instituicoesRepository.saveAll(Arrays.asList(i1, i2));

        Usuario u1 = new Usuario(1, "Higor Feio", "higor@gmail.com", true);

        Usuario u2 = new Usuario(2, "Matheus Cheirador", "matheuscheirador@gmail.com", false);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));



        Calculos cal1 = new Calculos(1, "matematica", "subtrair");
        Calculos cal2 = new Calculos(4, "matematica", "somar");
        calculoRepository.saveAll(Arrays.asList(cal1, cal2));

//        Emprestimo e1 = new Emprestimo(null, u1, new Date(System.currentTimeMillis()));

    //    emprestimoRepository.saveAll(Arrays.asList(e1, e2, e3));



    }
}
