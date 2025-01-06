package com.matiwe.api_republikanos.dto.record;

import com.matiwe.api_republikanos.model.enums.UserRole;

public record RegisterDTO(String login, String senha, String nome, UserRole role) {
}
