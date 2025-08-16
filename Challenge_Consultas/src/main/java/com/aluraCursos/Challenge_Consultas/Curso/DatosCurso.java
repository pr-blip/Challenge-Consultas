package com.aluraCursos.Challenge_Consultas.Curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso(
        @NotNull Long id,
        @NotBlank String nombre,
        @NotNull Categoria categoria
        ) {
}
