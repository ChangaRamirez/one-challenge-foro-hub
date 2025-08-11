package com.alura.challenge_foro_hub.domain.usuario;

public record DatosAutenticacionUsuario(
        String correoElectronico,
        String contrasena
) {}