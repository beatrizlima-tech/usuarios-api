package br.com.cotiinformatica.usuarios_api.dtos;

public record AutenticarUsuarioRequest(
        String email,
        String senha
) {
}
