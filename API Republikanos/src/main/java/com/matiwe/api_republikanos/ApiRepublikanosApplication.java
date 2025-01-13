package com.matiwe.api_republikanos;

import com.matiwe.api_republikanos.model.Usuario;
import com.matiwe.api_republikanos.model.enums.UserRole;
import com.matiwe.api_republikanos.repository.UsuarioRepository;
import com.matiwe.api_republikanos.service.UsuarioService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Republikanos", version = "2.8.1", description = "Uma API de busca e oferta de repúblicas"))
public class ApiRepublikanosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRepublikanosApplication.class, args);
    }

    @Bean
    CommandLineRunner popularBanco (@Autowired UsuarioRepository usuarioRepository,
                                    @Autowired UsuarioService usuarioService) {
        return args -> {
            // Adicionando os Usuarios:
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            usuarioRepository.save(new Usuario("Tiago123", encoder.encode("senha"),
                    "Tiago Freitas", UserRole.ADMIN));
            usuarioRepository.save(new Usuario("WSS777", encoder.encode("1234"),
                    "Wellyson", UserRole.USER));
            usuarioRepository.save(new Usuario("Maria Rita", encoder.encode("0000"),
                    "Maria Rita", UserRole.USER));

            // Adicionando os Anuncios das Republicas:

        };
    }

}
