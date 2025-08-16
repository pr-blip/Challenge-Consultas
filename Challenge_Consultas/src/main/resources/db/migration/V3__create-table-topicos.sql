create table topicos(

    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo varchar(200) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado varchar(50) NOT NULL,
    usuario_id bigint NOT NULL,
    curso_id bigint NOT NULL,


    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN key (curso_id) REFERENCES cursos(id) On DELETE CASCADE
);