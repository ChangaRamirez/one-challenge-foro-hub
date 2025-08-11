package com.alura.challenge_foro_hub.domain.topico.DTO;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizacionTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotBlank String curso
) {}
