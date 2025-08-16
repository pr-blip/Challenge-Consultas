package com.aluraCursos.Challenge_Consultas.domain.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosUsuario(
        @NotBlank String nombre,
        @NotBlank @Email String correo_electronico,
        @NotBlank @Pattern(     regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
                message = "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número"
        ) String contrasena
) {
}
