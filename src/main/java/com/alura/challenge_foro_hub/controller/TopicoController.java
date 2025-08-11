package com.alura.challenge_foro_hub.controller;

import com.alura.challenge_foro_hub.domain.topico.*;
import com.alura.challenge_foro_hub.domain.topico.DTO.DatosListadoTopico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    // POST /topicos -> 201 Created + Location
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos,
                                                          UriComponentsBuilder uriBuilder) {
        System.out.println("📌 Entró a POST /topicos");

        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tópico duplicado (título + mensaje)");
        }

        Topico topico = Topico.builder()
                .titulo(datos.titulo())
                .mensaje(datos.mensaje())
                .autor(datos.autor())
                .curso(datos.curso())
                .fechaCreacion(LocalDateTime.now())
                .build();

        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        var cuerpo = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getFechaCreacion()
                // si tu DTO incluye estado, agrega: topico.getEstado()
        );
        return ResponseEntity.created(uri).body(cuerpo);
    }

    // GET /topicos -> paginado
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listar(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC)
            Pageable pageable) {

        var page = repository.findAll(pageable).map(DatosListadoTopico::new);
        return ResponseEntity.ok(page);
    }
}