package com.matiwe.api_republikanos;

import com.matiwe.api_republikanos.model.Usuario;
import com.matiwe.api_republikanos.repository.UsuarioRepository;
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
    CommandLineRunner popularBanco (@Autowired UsuarioRepository usuarioRepository) {
        return args -> {
            // Adicionando os Usuarios:
            usuarioRepository.save(new Usuario("Tiago123", "senha", "Tiago Freitas"));
            usuarioRepository.save(new Usuario("WSS777", "1234", "Wellyson"));
            usuarioRepository.save(new Usuario("Maria R7", "0000", "Maria Rita"));
        };
    }

}
