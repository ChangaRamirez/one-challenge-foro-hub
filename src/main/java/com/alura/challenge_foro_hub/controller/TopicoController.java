package com.alura.challenge_foro_hub.controller;

import com.alura.challenge_foro_hub.domain.topico.Topico;
import com.alura.challenge_foro_hub.domain.topico.TopicoRepository;
import com.alura.challenge_foro_hub.domain.topico.DatosRegistroTopico;
import com.alura.challenge_foro_hub.domain.topico.DatosRespuestaTopico;
import com.alura.challenge_foro_hub.domain.topico.DTO.DatosListadoTopico;
import com.alura.challenge_foro_hub.domain.topico.DTO.DatosDetalleTopico;
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

    // POST /topicos -> 201 + Location
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos,
                                                          UriComponentsBuilder uriBuilder) {
        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tópico duplicado (título + mensaje).");
        }

        var topico = Topico.builder()
                .titulo(datos.titulo())
                .mensaje(datos.mensaje())
                .autor(datos.autor())
                .curso(datos.curso())
                .fechaCreacion(LocalDateTime.now())
                .build();

        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        var body = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getFechaCreacion()
        );
        return ResponseEntity.created(uri).body(body);
    }

    // GET /topicos -> listado paginado y ordenado
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listar(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC)
            Pageable pageable) {
        var page = repository.findAll(pageable).map(DatosListadoTopico::new);
        return ResponseEntity.ok(page);
    }

    // GET /topicos/{id} -> detalle por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallar(@PathVariable Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
}