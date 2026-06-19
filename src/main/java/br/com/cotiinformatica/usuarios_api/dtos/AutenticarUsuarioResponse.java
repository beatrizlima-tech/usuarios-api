package br.com.cotiinformatica.usuarios_api.dtos;

import java.time.LocalDateTime;

public record AutenticarUsuarioResponse(
        Integer id,
        String nome,
        String email,
        String perfil,
        LocalDateTime dataHoraAcesso,
        String accessToken
) {
}
