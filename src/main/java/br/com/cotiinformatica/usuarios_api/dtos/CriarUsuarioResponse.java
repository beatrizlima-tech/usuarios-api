package br.com.cotiinformatica.usuarios_api.dtos;

public record CriarUsuarioResponse(
        String mensagem,
        String nomeUsuario,
        String emailUsuario,
        String perfilUsuario
) {
}
