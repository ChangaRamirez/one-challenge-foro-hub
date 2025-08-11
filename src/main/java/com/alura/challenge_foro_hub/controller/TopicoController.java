package com.alura.challenge_foro_hub.controller;

import com.alura.challenge_foro_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public DatosRespuestaTopico registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        System.out.println("📌 Entró a POST /topicos");
        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new RuntimeException("Tópico duplicado");
        }
        Topico topico = Topico.builder()
                .titulo(datos.titulo())
                .mensaje(datos.mensaje())
                .autor(datos.autor())
                .curso(datos.curso())
                .fechaCreacion(LocalDateTime.now())
                .build();
        repository.save(topico);
        return new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso(), topico.getFechaCreacion());
    }
}