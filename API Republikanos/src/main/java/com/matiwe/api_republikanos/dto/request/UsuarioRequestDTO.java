package com.matiwe.api_republikanos.dto.request;

import com.matiwe.api_republikanos.model.enums.UserRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UsuarioRequestDTO {
    @NotBlank(message = "O login é obrigatório")
    private String login;

    @NotBlank(message = "A senha é obrigatória")
    @Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
        message = "A senha deve ter no mínimo 8 caracteres, contendo letras e números."
    )

    private String senha;

    private String nome;

    private UserRole role;
}
