package com.matiwe.api_republikanos.controller;

import com.matiwe.api_republikanos.dto.record.AuthenticationDTO;
import com.matiwe.api_republikanos.dto.record.LoginResponseDTO;
import com.matiwe.api_republikanos.dto.request.UsuarioRequestDTO;
import com.matiwe.api_republikanos.model.Usuario;
import com.matiwe.api_republikanos.repository.UsuarioRepository;
import com.matiwe.api_republikanos.security.TokenService;
import com.matiwe.api_republikanos.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioService usuarioService;


    @Operation(summary = "Realiza o login de um usuário ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Credenciais incorretas"),

    })
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(summary = "Realiza o registro de um usuário ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Novo usuário registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Informações inválidas para registro"),

    })
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsuarioRequestDTO data) {
        if(this.usuarioRepository.findByLogin(data.getLogin()) != null)
            return ResponseEntity.badRequest().build();

        usuarioService.register(data);

        return ResponseEntity.ok().build();
    }
}