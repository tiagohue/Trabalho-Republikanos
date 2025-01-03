package com.matiwe.api_republikanos;

import com.matiwe.api_republikanos.model.Usuario;
import com.matiwe.api_republikanos.repository.UsuarioRepository;
import com.matiwe.api_republikanos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRepublikanosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRepublikanosApplication.class, args);
    }

    @Bean
    CommandLineRunner popularBanco (@Autowired UsuarioRepository usuarioRepository,
                                    @Autowired UsuarioService usuarioService) {
        return args -> {
            // Adicionando os Usuarios:
            usuarioRepository.save(new Usuario("Tiago123", usuarioService.gerarHash("senha"), "Tiago Freitas"));
            usuarioRepository.save(new Usuario("WSS777", usuarioService.gerarHash("1234"), "Wellyson"));
            usuarioRepository.save(new Usuario("Maria R7", usuarioService.gerarHash("0000"), "Maria Rita"));

            // Adicionando os Anuncios das Republicas:

        };
    }

}
