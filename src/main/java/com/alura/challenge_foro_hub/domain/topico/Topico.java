package com.alura.challenge_foro_hub.domain.topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    // en BD es TEXT, alineamos con JPA:
    @Lob
    @Column(columnDefinition = "TEXT")
    private String mensaje;

    private String autor;
    private String curso;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoTopico estado;

    @PrePersist
    void prePersist() {
        if (fechaCreacion == null) fechaCreacion = LocalDateTime.now();
        if (estado == null) estado = EstadoTopico.ABIERTO;
    }
}