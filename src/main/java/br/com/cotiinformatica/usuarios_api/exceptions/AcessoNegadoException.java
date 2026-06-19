package br.com.cotiinformatica.usuarios_api.exceptions;

public class AcessoNegadoException extends RuntimeException {

  //Método para retornar a mensagem de erro quando o usuário não for autenticado

  @Override
  public String getMessage() {
    return "Acesso negado";
  }
}
