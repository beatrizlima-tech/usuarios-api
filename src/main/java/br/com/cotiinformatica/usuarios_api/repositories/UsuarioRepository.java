package br.com.cotiinformatica.usuarios_api.repositories;

import br.com.cotiinformatica.usuarios_api.entities.Perfil;
import br.com.cotiinformatica.usuarios_api.entities.Usuario;
import br.com.cotiinformatica.usuarios_api.factories.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    @Autowired
    private ConnectionFactory connectionFactory;

    public void inserir(Usuario usuario) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
            insert into usuarios(nome, email, senha, data_hora_cadastro, perfil_id)
            values(?, ?, ?, now(), ?)
            """);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setInt(4, usuario.getPerfilId());
            statement.execute();
        }
    }

    public Usuario obterPorEmail(String email) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                select id, nome, email, senha, perfil_id
                from usuarios
                where email = ?
            """);
            statement.setString(1, email);
            var result = statement.executeQuery();

            Usuario usuario = null; //vazio

            if (result.next()) {
                usuario = new Usuario();
                usuario.setId(result.getInt("id"));
                usuario.setNome(result.getString("nome"));
                usuario.setEmail(result.getString("email"));
                usuario.setSenha(result.getString("senha"));
                usuario.setPerfilId(result.getInt("perfil_id"));
            }

            return usuario;
        }
    }

}