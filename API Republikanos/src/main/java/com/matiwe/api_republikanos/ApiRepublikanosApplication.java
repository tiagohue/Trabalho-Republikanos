package com.matiwe.api_republikanos;

import com.matiwe.api_republikanos.dto.request.*;
import com.matiwe.api_republikanos.model.Usuario;
import com.matiwe.api_republikanos.model.enums.Comodo;
import com.matiwe.api_republikanos.model.enums.Servico;
import com.matiwe.api_republikanos.model.enums.UserRole;
import com.matiwe.api_republikanos.model.enums.Vaga;
import com.matiwe.api_republikanos.repository.AnuncioRepublicaRepository;
import com.matiwe.api_republikanos.repository.UsuarioRepository;
import com.matiwe.api_republikanos.service.AnuncioPessoalService;
import com.matiwe.api_republikanos.service.AnuncioRepublicaService;
import com.matiwe.api_republikanos.service.UsuarioService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Republikanos", version = "2.8.1", description = "Uma API de busca e oferta de repúblicas"))
public class ApiRepublikanosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRepublikanosApplication.class, args);
    }

    @Bean
    CommandLineRunner popularBanco (@Autowired UsuarioService usuarioService,
                                    @Autowired AnuncioRepublicaService anuncioRepublicaService, AnuncioPessoalService anuncioPessoalService) {
        return args -> {
            // Adicionando os Usuarios:
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            usuarioService.register(new UsuarioRequestDTO("Tiago123", "senha", "Tiago Freitas", UserRole.ADMIN));
            usuarioService.register(new UsuarioRequestDTO("WSS777", "1234", "Wellyson", UserRole.USER));
            usuarioService.register(new UsuarioRequestDTO("Maria Rita", "0000", "Maria Rita", UserRole.USER));

            // Adicionando os Anuncios das Republicas:
            anuncioRepublicaService.register(
                    new AnuncioRepublicaRequestDTO(200.00,
                    "Bem localizado e movimentado.",
                    List.of(Comodo.QUARTO, Comodo.QUARTO, Comodo.SALA_DE_ESTAR, Comodo.COZINHA, Comodo.BANHEIRO),
                    List.of(Servico.AGUA, Servico.ENERGIA, Servico.ALUGUEL),
                    List.of(Vaga.MASCULINA_DISPONIVEL, Vaga.MASCULINA_DISPONIVEL, Vaga.MASCULINA_OCUPADA),
                    new LocalizacaoRequestDTO("apartamento", "22", "Centro"),
                    new ContatoRequestDTO("999999991", "exemplo1@gmail.com")
                    )
            );
            anuncioRepublicaService.register(
                    new AnuncioRepublicaRequestDTO(100.00,
                            "Casa tranquila e boa para estudar. E tem garagem!",
                            List.of(Comodo.QUARTO, Comodo.QUARTO, Comodo.QUARTO,Comodo.SALA_DE_ESTAR, Comodo.COZINHA,
                                    Comodo.BANHEIRO, Comodo.QUINTAL, Comodo.GARAGEM),
                            List.of(Servico.AGUA, Servico.ENERGIA),
                            List.of(Vaga.MASCULINA_DISPONIVEL, Vaga.FEMININA_DISPONIVEL, Vaga.MASCULINA_OCUPADA,
                                    Vaga.FEMININA_OCUPADA),
                            new LocalizacaoRequestDTO("Casa", "2211", "São Bento"),
                            new ContatoRequestDTO("999999992", "exemplo2@gmail.com")
                    )
            );
            anuncioRepublicaService.register(
                    new AnuncioRepublicaRequestDTO(250.00,
                            "Ao lado da Chrisfapi",
                            List.of(Comodo.QUARTO, Comodo.QUARTO, Comodo.SALA_DE_ESTAR, Comodo.COZINHA, Comodo.BANHEIRO,
                                    Comodo.VARANDA, Comodo.SALA_DE_JANTAR),
                            List.of(Servico.AGUA, Servico.ENERGIA, Servico.ALUGUEL, Servico.INTERNET),
                            List.of(Vaga.MASCULINA_DISPONIVEL, Vaga.MASCULINA_DISPONIVEL, Vaga.MASCULINA_OCUPADA),
                            new LocalizacaoRequestDTO("Casa", "1622", "Bairro da Chrisfapi"),
                            new ContatoRequestDTO("999999993", "exemplo3@gmail.com")
                    )
            );

            // Adicionando os Anuncios Pessoais:
            anuncioPessoalService.register(
                    new AnuncioPessoalRequestDTO(
                            "Dev Estagiário",
                            "Gosto de Ouvir música alto!",
                            "Frequento a academia às 19:00hrs",
                            "",
                            20,
                            "Centro",
                            200.00,
                            new ContatoRequestDTO("999999994", "exemplo4@gmail.com")
                    )
            );
            anuncioPessoalService.register(
                    new AnuncioPessoalRequestDTO(
                            "Pesquisador",
                            "Odeio música alta, gosto de silêncio.",
                            "Faço corridas matinais",
                            "Sei tocar piano",
                            23,
                            "",
                            170.00,
                            new ContatoRequestDTO("999999995", "exemplo5@gmail.com")
                    )
            );
            anuncioPessoalService.register(
                    new AnuncioPessoalRequestDTO(
                            "",
                            "Gosto de ler livros",
                            "Frequento a academia às 6:00hrs",
                            "",
                            20,
                            "Centro",
                            200.00,
                            new ContatoRequestDTO("999999994", "exemplo4@gmail.com")
                    )
            );
        };
    }

}
