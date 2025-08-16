create table  usuarios_perfiles(

    usuario_id bigint NOT NULL,
    perfil_id bigint NOT NULL,

    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN Key (perfil_id) REFERENCES perfiles(id) ON DELETE CASCADE
);