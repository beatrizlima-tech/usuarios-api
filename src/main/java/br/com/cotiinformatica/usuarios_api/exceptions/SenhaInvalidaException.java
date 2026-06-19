package br.com.cotiinformatica.usuarios_api.exceptions;

public class SenhaInvalidaException extends RuntimeException {

    /*
        Implementar um método para retornar a mensagem
        de erro padrão desta classe de exceção
     */

    @Override
    public String getMessage() {
        return "A senha deve ter pelo menos uma letra minúscula, uma letra maiúscula, um número, um  símbolo e no mínimo 8 caracteres.";
    }
}