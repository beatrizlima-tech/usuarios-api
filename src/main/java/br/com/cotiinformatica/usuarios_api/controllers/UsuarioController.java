package br.com.cotiinformatica.usuarios_api.controllers;

import br.com.cotiinformatica.usuarios_api.dtos.AutenticarUsuarioRequest;
import br.com.cotiinformatica.usuarios_api.dtos.CriarUsuarioRequest;
import br.com.cotiinformatica.usuarios_api.entities.Usuario;
import br.com.cotiinformatica.usuarios_api.exceptions.AcessoNegadoException;
import br.com.cotiinformatica.usuarios_api.exceptions.EmailJaCadastradoException;
import br.com.cotiinformatica.usuarios_api.exceptions.SenhaInvalidaException;
import br.com.cotiinformatica.usuarios_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("autenticar")
    public ResponseEntity<?> autenticar(@RequestBody AutenticarUsuarioRequest request) {
        try{

            var response = usuarioService.autenticarUsuario(request);

            //HTTP 200 (OK)
            return ResponseEntity.ok(response);

        }
        catch (AcessoNegadoException e) {
            //HTTP 401 (UNAUTHORIZED)
            return ResponseEntity.status(401).body(e.getMessage());
        }
        catch (Exception e) {
            //HTTP 500 (INTERNAL SERVER ERROR)
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    @PostMapping("criar")
    public ResponseEntity<?> criar(@RequestBody CriarUsuarioRequest request) {
        try {
            var response = usuarioService.criarUsuario(request);

            //HTTP 201 (CREATED)
            return ResponseEntity.status(201).body(response);
        }
        catch (SenhaInvalidaException e) {
            //HTTP 400 (BAD REQUEST)
            return ResponseEntity.status(400).body(e.getMessage());
        }
        catch (EmailJaCadastradoException e) {
            //HTTP 409 (CONFLICT)
            return ResponseEntity.status(409).body(e.getMessage());
        }
        catch(Exception e) {
            //HTTP 500 (INTERNAL SERVER ERROR)
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}