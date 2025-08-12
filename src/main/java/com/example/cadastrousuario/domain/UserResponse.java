package com.example.cadastrousuario.domain;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email) {

}
