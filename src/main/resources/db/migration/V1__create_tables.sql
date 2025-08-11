-- Perfiles
CREATE TABLE perfiles (
  id BIGINT AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- Usuarios
CREATE TABLE usuarios (
  id BIGINT AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  correo_electronico VARCHAR(150) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Relación usuarios-perfiles (PK compuesta)
CREATE TABLE usuarios_perfiles (
  usuario_id BIGINT NOT NULL,
  perfil_id BIGINT NOT NULL,
  PRIMARY KEY (usuario_id, perfil_id),
  CONSTRAINT fk_up_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
  CONSTRAINT fk_up_perfil FOREIGN KEY (perfil_id) REFERENCES perfiles(id)
);

-- Cursos
CREATE TABLE cursos (
  id BIGINT AUTO_INCREMENT,
  nombre VARCHAR(150) NOT NULL,
  categoria VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- Tópicos
CREATE TABLE topicos (
  id BIGINT AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL,
  mensaje TEXT NOT NULL,
  autor VARCHAR(255) NOT NULL,
  curso VARCHAR(255) NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uq_titulo_mensaje (titulo, mensaje(255))
);

-- Respuestas
CREATE TABLE respuestas (
  id BIGINT AUTO_INCREMENT,
  mensaje TEXT NOT NULL,
  topico_id BIGINT NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  autor_id BIGINT NOT NULL,
  solucion BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id),
  CONSTRAINT fk_resp_topico FOREIGN KEY (topico_id) REFERENCES topicos(id),
  CONSTRAINT fk_resp_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id),
  INDEX idx_respuestas_topico (topico_id)
);
