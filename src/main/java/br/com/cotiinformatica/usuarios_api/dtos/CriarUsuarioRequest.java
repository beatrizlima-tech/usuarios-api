package br.com.cotiinformatica.usuarios_api.dtos;

public record CriarUsuarioRequest(
        String nome, //Nome do usuário
        String email, //Email do usuário
        String senha //Senha do usuário
) {
}
