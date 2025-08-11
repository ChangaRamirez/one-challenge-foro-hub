package com.alura.challenge_foro_hub.domain.topico.DTO;

import com.alura.challenge_foro_hub.domain.topico.EstadoTopico;
import com.alura.challenge_foro_hub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        EstadoTopico estado,
        String autor,
        String curso
) {
    public DatosListadoTopico(Topico t) {
        this(t.getId(), t.getTitulo(), t.getMensaje(), t.getFechaCreacion(), t.getEstado(), t.getAutor(), t.getCurso());
    }
}
