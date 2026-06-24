package br.com.cotiinformatica.usuarios_api.components;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtComponent {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private String jwtExpiration;

    //Método para retornar a data de expiração do token

    public Date getExpirationDate() {
        var dataAtual = new Date();
        var now = new Date(); //capturando a data atual do sistema

        //Retornando uma nova data adicionando o tempo
        return new Date(dataAtual.getTime()
                         + Integer.parseInt(jwtExpiration));
    }

    //Método para gerar e retornar o TOKEN JWT
    public String getAcessToken(String emailUsuario, String perfil) {
        return Jwts.builder()
                .setSubject(emailUsuario) //SUBJECT: Identificação
                .claim("perfil", perfil) //CLAIMS: Informação
                .setIssuedAt(new Date()) //Data e hora
                    //de geração do TOKEN
                .setExpiration(getExpirationDate()) //Data e hora
                    //de expiração do TOKEN
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                            //Assinatura do TOKEN utilizando
                            //o algoritmo HS256 e a chave secreta
                .compact(); //Gerando o TOKEN
    }

    //Método para ler o email do usuário contigo no TOKEN JWT

    public String getEmailUsuario(HttpServletRequest http) throws Exception {
        String authorization = http.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return null;
        }

        String token = authorization.substring(7);

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
