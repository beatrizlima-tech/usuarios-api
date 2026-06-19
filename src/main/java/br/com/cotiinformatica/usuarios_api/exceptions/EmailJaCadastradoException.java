package br.com.cotiinformatica.usuarios_api.exceptions;

public class EmailJaCadastradoException extends RuntimeException {

    /*
        Implementar um método para retornar a mensagem
        de erro padrão desta classe de exceção
     */

    @Override
    public String getMessage() {
        return "O email informada já está cadastrado. Por favor, informe outro email.";
    }
}
