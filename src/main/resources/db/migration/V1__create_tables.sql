-- Usuarios y perfiles
CREATE TABLE perfiles (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE usuarios (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  correo_electronico VARCHAR(150) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE usuarios_perfiles (
  usuario_id BIGINT NOT NULL,
  perfil_id BIGINT NOT NULL,
  PRIMARY KEY (usuario_id, perfil_id),
  CONSTRAINT fk_up_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
  CONSTRAINT fk_up_perfil FOREIGN KEY (perfil_id) REFERENCES perfiles(id)
);

-- Cursos
CREATE TABLE cursos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(150) NOT NULL,
  categoria VARCHAR(100) NOT NULL
);

-- Tópicos
CREATE TABLE topicos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(200) NOT NULL,
  mensaje TEXT NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  status VARCHAR(50) NOT NULL,
  autor_id BIGINT NOT NULL,
  curso_id BIGINT NOT NULL,
  CONSTRAINT fk_topico_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id),
  CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES cursos(id),
  INDEX idx_topicos_fecha (fecha_creacion)
);

-- Respuestas
CREATE TABLE respuestas (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  mensaje TEXT NOT NULL,
  topico_id BIGINT NOT NULL,
  fecha_creacion DATETIME NOT NULL,
  autor_id BIGINT NOT NULL,
  solucion BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT fk_resp_topico FOREIGN KEY (topico_id) REFERENCES topicos(id),
  CONSTRAINT fk_resp_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id),
  INDEX idx_respuestas_topico (topico_id)
);