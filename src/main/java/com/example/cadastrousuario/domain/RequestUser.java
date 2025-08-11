package com.example.cadastrousuario.domain;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUser(
        UUID id,
        @NotBlank
        String name,
        @NotNull
        String email) {
}
