package br.com.cotiinformatica.usuarios_api.dtos;

public record DadosUsuarioResponse(
        Integer id,
        String nome,
        String email,
        String perfil
) {
}
