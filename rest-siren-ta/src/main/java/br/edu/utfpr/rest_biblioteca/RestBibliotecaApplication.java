package br.edu.utfpr.rest_biblioteca;

import br.edu.utfpr.rest_biblioteca.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestBibliotecaApplication implements CommandLineRunner {
    @Autowired
    private DbService dbService;

    public static void main(String[] args) {
        SpringApplication.run(RestBibliotecaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dbService.iniciarBancoDeDados();
    }
}
