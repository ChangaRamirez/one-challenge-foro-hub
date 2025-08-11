package com.alura.challenge_foro_hub.controller;

import com.alura.challenge_foro_hub.domain.usuario.AutenticacionService;
import com.alura.challenge_foro_hub.domain.usuario.DatosAutenticacionUsuario;
import com.alura.challenge_foro_hub.infra.security.DatosTokenJWT;
import com.alura.challenge_foro_hub.infra.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacionController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public DatosTokenJWT autenticar(@RequestBody DatosAutenticacionUsuario datos) {
        System.out.println("Entró a /login controller con: " + datos.correoElectronico());
        var authToken  = new UsernamePasswordAuthenticationToken(datos.correoElectronico(), datos.contrasena());
        var auth = manager.authenticate(authToken);
        var tokenJWT = tokenService.generarToken(datos.correoElectronico());
        return new DatosTokenJWT(tokenJWT);
    }
}