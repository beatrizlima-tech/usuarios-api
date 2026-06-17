package br.com.cotiinformatica.usuarios_api.services;

import br.com.cotiinformatica.usuarios_api.dtos.CriarUsuarioRequest;
import br.com.cotiinformatica.usuarios_api.dtos.CriarUsuarioResponse;
import br.com.cotiinformatica.usuarios_api.entities.Usuario;
import br.com.cotiinformatica.usuarios_api.repositories.PerfilRepository;
import br.com.cotiinformatica.usuarios_api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Service
public class UsuarioService {

    @Autowired //inicialização automática
    private UsuarioRepository usuarioRepository;

    @Autowired //inicialização automática
    private PerfilRepository perfilRepository;

    //Método para implementarmos um fluxo de criação
    //de usuário no sistema (novo usuário)
    public CriarUsuarioResponse criarUsuario(CriarUsuarioRequest request) throws Exception {

        var usuario = new Usuario();

        //Capturar o nome e o email do usuário
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());

        //Capturar e criptografar a senha do usuário
        usuario.setSenha(criptografarSenha(request.senha()));

        //Buscar no banco de dados o registro do perfil 'Operador'
        var perfil = perfilRepository.obterPorNome("Operador");

        //Associar o usuário ao perfil
        usuario.setPerfilId(perfil.getId());

        //Salvar no banco de dados
        usuarioRepository.inserir(usuario);

        //Retornar os dados da resposta
        return new CriarUsuarioResponse(
                "Usuário criado com sucesso.",
                usuario.getNome(),
                usuario.getEmail(),
                perfil.getNome()
        );
    }

    //Método para fazer a criptografia da senha do usuário
    private String criptografarSenha(String senha) throws Exception {

        var digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(senha.getBytes(StandardCharsets.UTF_8));

        var hexString = new StringBuilder();

        for (byte b : hashBytes) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
