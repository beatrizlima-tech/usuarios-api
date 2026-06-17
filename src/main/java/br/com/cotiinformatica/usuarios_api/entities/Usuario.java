package br.com.cotiinformatica.usuarios_api.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataHoraCadastro;
    private Integer perfilId;
}