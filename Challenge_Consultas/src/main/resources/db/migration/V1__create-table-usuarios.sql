create table usuarios(

    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(200) NOT NULL,
    correo_electronico varchar(150) NOT NULL UNIQUE,
    contrasena varchar(255) NOT NULL

);